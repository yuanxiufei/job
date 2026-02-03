package com.reginyuan.job.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 添加RestController注解的类，生成API文档
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                // 对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API 描述基本信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 设置标题
                .title("招聘网可视化分析系统")
                // 描述
                .description("后端接口文档")
                // 许可证
                .license("reginyuan")
                .licenseUrl("https://www.reginyuan.com/")
                .version("1.0")
                .build();
    }
}
