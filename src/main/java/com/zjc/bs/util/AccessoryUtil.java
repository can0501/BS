package com.zjc.bs.util;


import com.zjc.bs.entity.accessory.Accessory;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author linxc
 * @Description 附件上传下载
 * @Date Created in 2018/9/10
 */
public class AccessoryUtil {
    public static Accessory uploadFile(MultipartFile file, String rootPath, String type){
        if (file.isEmpty()) {
            return null;
        }
        Accessory accessory;
        try {
            // 判断文件路径是否存在，不存在则创建
            String theRootPath = FileStringUtil.mkdirs(rootPath);

            String fileName = FileStringUtil.genUUID();
            // 文件原名-带后缀
            String originalFilename = file.getOriginalFilename();
            originalFilename = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
            // 文件类型
            String suffix = FileStringUtil.getSuffixByFileName(originalFilename);
            // 文件名
            StringBuilder sb = new StringBuilder();
            sb.append(fileName).append(".").append(suffix);
            fileName = sb.toString();

            // 文件存储路径
            sb = new StringBuilder();
            sb.append(theRootPath).append("/").append(fileName);
            String filePath = sb.toString();

            // 保存文件到本地
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            accessory = Accessory.builder().filename(fileName).createtime(new Date()).ftype(type).build();
            return accessory;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @descrption 验证文件格式，这里主要验证后缀名
     * @author xdwang
     * @create 2012-11-19下午4:08:12
     * @param file
     *            MultipartFile对象
     * @param maxLength
     *            文件最大限制
     * @param allowExtName
     *            不允许上传的文件扩展名
     * @return 文件格式是否合法
     */
    private static boolean validateFile(MultipartFile file, long maxLength,
                                        String[] allowExtName) {
        if (file.getSize() < 0 || file.getSize() > maxLength)
            return false;
        String filename = file.getOriginalFilename();

        // 处理不选择文件点击上传时，也会有MultipartFile对象，在此进行过滤
        if (filename == "") {
            return false;
        }
        String extName = filename.substring(filename.lastIndexOf("."))
                .toLowerCase();
        if (allowExtName == null || allowExtName.length == 0
                || Arrays.binarySearch(allowExtName, extName) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
