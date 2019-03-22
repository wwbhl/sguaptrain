package com.sgcc.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.cloud.bus.BusAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.ZipkinAutoConfiguration;



/**
 * 微服务应用服务启动类
 * 1、（@EnableDiscoveryClient）注解为链接微服务注册中心用，如实际环境中使用注册中心，请取消注释部分，
 *     与配置文件中相关注册中心配置信息结合使用。
 * 2、SG-UAP默认关闭数据库链接功能，如实际环境中需要链接数据库，请将以下“JpaRepositoriesAutoConfiguration.class,HibernateJpaAutoConfiguration.class”
 *    部分内容删除即可。
 * 3、SG-UAP默认关闭缓存功能，如实际环境需要缓存功能，请先安装redis，然后将以下“SessionAutoConfiguration.class”部分内容删除即可。
 * 4、SG-UAP默认关闭配置服务连接功能，如实际环境中需要连接配置服务，请按先安装配置服务，然后将以下"BusAutoConfiguration.class"部分内容删除即可。
 * 5、SG-UAP默认关闭调用链监控功能，如实际环境需要调用链监控功能，请将以下“ZipkinAutoConfiguration.class”部分内容删除即可。
 * 6、SG-UAP默认配置扫描一个包“com.sgcc.uap.rest.annotation”，如新增场景代码，需要修改scanBasePackages配置。例如新增demo场景，包名为com.sgcc.uap.demo，
 *    则需修改scanBasePackages 为 “scanBasePackages={"com.sgcc.uap","com.sgcc.uap.rest.annotation"}”
 * @author zhangzz
 *
 */

@SpringBootApplication(scanBasePackages={"com.sgcc.uap","com.sgcc.uap.rest.annotation"},exclude={SessionAutoConfiguration.class,BusAutoConfiguration.class})
//@EnableDiscoveryClient
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
