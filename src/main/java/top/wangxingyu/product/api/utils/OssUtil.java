package top.wangxingyu.product.api.utils;


import com.aliyun.oss.OSS;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.wangxingyu.product.api.config.OssConfig;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author 笼中雀
 */

@Component
@AllArgsConstructor
public class OssUtil {
    private final OSS ossClient;

    private final OssConfig ossConfig;

    public String uploadFile(MultipartFile file) {
        try{
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名不能为空");

            }

            String fileName = "upload/" + UUID.randomUUID() + "_" + originalFilename;

            InputStream inputStream = file.getInputStream();

            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);

            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint().replace("https://","") + "/" + fileName;

        }catch (Exception e){
            throw new RuntimeException("文件上传失败",e);
        }
    }
}
