package rspResult;

import bloomFilter.MyBloomFilter;
import org.junit.Test;

/**
 * @Package: rspResult
 * @Author: Chen Long
 * @Description:
 * @Datetime: 2021/11/27 20:43:10
 */
public class Main {
    @Test
    public void test(){
        System.out.println(RspResult.success(new MyBloomFilter()));
    }

}
