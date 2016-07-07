package com.hengyun.controller.im;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.http.OAuthToken;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月7日 上午11:23:11
* 类说明
*/
public class WeixinManager {

	private static Weixin weixin = null;  
    private static String accessToken = null;  
    private final static String url = "jdbc:mysql://127.0.0.1:3306/hengyun";  
    private final static String name = "root";  
    private final static String pwd = "pba123*";  
    private final static String driver = "com.mysql.jdbc.Driver"; 
    
    public static Weixin getWeixin() throws WeixinException {  
        //获取配置  
        String appId = Configuration.getOAuthAppId();  
        String secret = Configuration.getOAuthSecret();  
        if (weixin == null || accessToken == null) {  
            if (Configuration.isDebug()) {  
                System.out.println("第一次运行，初始化Weixin对象");  
            }  
            //1.初始化Weixin对象  
            weixin = new Weixin();  
            //先从数据库查询，是否有未过期的access_token  
            OAuthToken oauthToken = getOAuthToken();  
            //判断，如果为null，则说明已过期，需要重新登录获取  
            if (oauthToken == null) {  
                if (Configuration.isDebug()) {  
                    System.out.println("从数据库中，未读取到Token或已过期!");  
                }  
                if (Configuration.isDebug()) {  
                    System.out.println("准备访问微信服务器，进行access_token获取!");  
                }  
                //2.第一次初始化，需要进行登录  
                oauthToken = weixin.login(appId, secret);  
                //重置  
                accessToken = oauthToken.getAccess_token();  
                if (Configuration.isDebug()) {  
                    System.out.println("访问微信服务器，获取access_token成功!");  
                }  
                if (Configuration.isDebug()) {  
                    System.out.println("准备保存到数据库!");  
                }  
                //3.保存Token  
                saveOAuthToken(oauthToken.getAccess_token(), oauthToken.getExpires_in());  
                if (Configuration.isDebug()) {  
                    System.out.println("保存到数据库成功!");  
                }  
            } else {  
                if (Configuration.isDebug()) {  
                    System.out.println("从数据库中，读取到Token，直接初始化!");  
                }  
                //2.初始化  
                weixin.init(oauthToken.getAccess_token(), appId, secret, oauthToken.getExpires_in());  
            }  
        } else {  
            if (Configuration.isDebug()) {  
                System.out.println("已存在Weixin对象，准备验证Token是否过期！");  
            }  
            //2.已经初始化，直接登录，如果未过期，默认不重新获取，如果重新获取则会改变accessToken，需要重新保存到数据库  
            OAuthToken oauthToken = weixin.login(appId, secret);  
            //如果相等，则不相同则说明重新获取过，需要保存到数据库  
            if (!oauthToken.getAccess_token().equals(accessToken)) {  
                if (Configuration.isDebug()) {  
                    System.out.println("Weixin对象Token已过期，已重新获取access_token,准备保存到数据库！");  
                }  
                //重置  
                accessToken = oauthToken.getAccess_token();  
                //3.保存Token  
                saveOAuthToken(oauthToken.getAccess_token(), oauthToken.getExpires_in());  
                if (Configuration.isDebug()) {  
                    System.out.println("保存到数据库成功!");  
                }  
            } else {  
                if (Configuration.isDebug()) {  
                    System.out.println("Weixin对象Token未过期，直接返回Weixin对象！");  
                }  
            }  
        }  
        return weixin;  
    }  
  
    //获取Accesstoken  
    private static OAuthToken getOAuthToken() {  
        OAuthToken token = null;  
        try {  
            //加载驱动  
            Class.forName(driver);  
        } catch (ClassNotFoundException ex) {  
            System.out.println("加载驱动异常！");  
        }  
        Connection conn = null;  
        Statement st = null;  
        ResultSet rs = null;  
        try {  
            //创建数据库链接  
            conn = DriverManager.getConnection(url, name, pwd);  
            //创建处理器  
            st = conn.createStatement();  
            //查询Token，读取1条记录  
            rs = st.executeQuery("select * from t_token order by createTime desc limit 0,1");  
            if (rs.next()) {  
                String access_token = rs.getString("access_token");  
                int expires_in = rs.getInt("expires_in");  
                java.sql.Timestamp createTime = rs.getTimestamp("createTime");  
                //先直接判断是否过期，获取当前时间毫秒数  
                //为了防止1秒前未过期，1秒后过期  
                //我们设定，初始化是，如果再5分钟内，算未过期，超过1分钟则重新获取  
                long now = new Date().getTime() + (1 * 60 * 1000);  
                //过期时间 = 创建时间 + (过期秒数 * 1000)  
                long exprexpiredTime = createTime.getTime() + (expires_in * 1000);  
                if (now < exprexpiredTime) {  
                    //计算剩余过期时间  
                    long expires = now - exprexpiredTime - (1 * 60 * 1000);  
                    //没有过期，初始化后返回  
                    token = new OAuthToken(access_token, (int) (expires / 1000));  
                }  
            }  
        } catch (SQLException ex) {  
            System.out.println("数据库操作异常：" + ex.getMessage());  
        } finally {  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException ex) {  
                    System.out.println("关闭数据集异常:" + ex.getMessage());  
                }  
            }  
            if (st != null) {  
                try {  
                    st.close();  
                } catch (SQLException ex) {  
                    System.out.println("关闭处理器异常:" + ex.getMessage());  
                }  
            }  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException ex) {  
                    System.out.println("关闭数据库链接异常:" + ex.getMessage());  
                }  
            }  
        }  
        return token;  
    }  
    
    //保存Accesstoken  
    private static void saveOAuthToken(String access_token, int expires_in) {  
        try {  
            //加载驱动  
            Class.forName(driver);  
        } catch (ClassNotFoundException ex) {  
            System.out.println("加载驱动异常！");  
        }  
        Connection conn = null;  
        PreparedStatement pst = null;  
        try {  
            //创建数据库链接  
            conn = DriverManager.getConnection(url, name, pwd);  
            //创建预处理器  
            pst = conn.prepareStatement("insert into t_token(access_token,expires_in,createTime)values(?,?,?)");  
            pst.setString(1, access_token);  
            pst.setInt(2, expires_in);  
            long now = new Date().getTime();  
            pst.setTimestamp(3, new java.sql.Timestamp(now));  
            pst.execute();  
        } catch (SQLException ex) {  
            System.out.println("数据库操作异常：" + ex.getMessage());  
        } finally {  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException ex) {  
                    System.out.println("关闭预处理器异常:" + ex.getMessage());  
                }  
            }  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException ex) {  
                    System.out.println("关闭数据库链接异常:" + ex.getMessage());  
                }  
            }  
        }  
    }  
    
    
}
