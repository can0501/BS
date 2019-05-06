package com.zjc.bs.api.accessory;

import com.zjc.bs.base.Response;
import com.zjc.bs.entity.accessory.Accessory;
import com.zjc.bs.service.accessory.AcessoryService;
import com.zjc.bs.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/accessory")

public class AccessoryApi {

    @Autowired
    AcessoryService acessoryService;
@RequestMapping("/upload")
    public Response upload(MultipartFile  file, Integer fid, String type) {
        Accessory accessory;
        try {
            accessory= AccessoryUtil.uploadFile(file, UploadRoot.root+"\\"+type, type);

        } catch (Exception e) {
            return Response.failure(Msg.UPLOAD_FALIED);
        }
        accessory.setFid(fid);
        if (acessoryService.addAccessory(accessory)) {
            return Response.success(null, Msg.UPLOAD_SUCCESS);
        }
        return Response.failure(Msg.UPLOAD_FALIED);

    }
    @RequestMapping("/getList")
    public LayUI getList(Accessory accessory) {
        List list = acessoryService.getAccessory(accessory);
        return LayUI.data(list.size(), list);

    }

    @RequestMapping("/delete")
    public Response delete(Accessory accessory) {
        if(acessoryService.deleteAccessory(accessory))
            return Response.failure(Msg.DEL_SUCCESS);
        return Response.failure(Msg.DEL_FALIED);

    }

    @RequestMapping("/getPhotos")
    public PhotoUtil getPhotos(Accessory accessory,Integer type) {

        return PhotoUtil.makePhotos(acessoryService.getAccessory(accessory),UploadRoot.types[type]);
    }
}
