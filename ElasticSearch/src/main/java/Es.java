import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Package: dataStructure_Algorithm.sort
 * @Author: Chen Long
 * @Description: 客户端实体,单例
 * @Datetime: 2021/5/8 0:18:20
 */
public class Es {
    private static final RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(new HttpHost("localhost", 1001, "http")));

    public static RestHighLevelClient getInstance() {
        return client;
    }
}
