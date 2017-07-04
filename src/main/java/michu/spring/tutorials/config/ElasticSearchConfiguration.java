package michu.spring.tutorials.config;

import java.io.File;
import java.io.IOException;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "michu.spring.tutorials.repository")
public class ElasticSearchConfiguration {
	
	
	@Bean
	public NodeBuilder nodeBuilder(){
		return new NodeBuilder();
		
	}
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws IOException{
		
		File tempFile = File.createTempFile("temp-elastic", Long.toString(System.nanoTime()));
		
		 System.out.println("Temp directory: " + tempFile.getAbsolutePath());
	        Settings.Builder elasticsearchSettings =
	                Settings.settingsBuilder()
	                        .put("http.enabled", "true") // 1
	                        .put("index.number_of_shards", "1")
	                        .put("path.data", new File(tempFile, "data").getAbsolutePath()) 
	                        .put("path.logs", new File(tempFile, "logs").getAbsolutePath()) 
	                        .put("path.work", new File(tempFile, "work").getAbsolutePath()) 
	                        .put("path.home", tempFile); // 3



	        return new ElasticsearchTemplate(nodeBuilder()
	                .local(true)
	                .settings(elasticsearchSettings.build())
	                .node()
	                .client());
			
	}

}
