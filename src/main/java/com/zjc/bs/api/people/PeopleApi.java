package com.zjc.bs.api.people;

import com.zjc.bs.base.JsonHelper;
import com.zjc.bs.base.Response;
import com.zjc.bs.entity.admin.People;
import com.zjc.bs.service.admin.PeoplerService;
import com.zjc.bs.util.LayUI;
import com.zjc.bs.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleApi {
    @Autowired
    PeoplerService peoplerService;



    @RequestMapping("listData")

    public LayUI listData(People people){

        return LayUI.data(peoplerService.getCount(people), peoplerService.getListByPage(people));
    }
    @RequestMapping("addPeople")

    public Response add(@RequestBody People people){
        if(peoplerService.add(people)!=0){
            return Response.success(null,Msg.ADD_SUCCESS);
        }
        return Response.failure(Msg.ADD_FALIED+"可能账号已存在");
    }

    @RequestMapping("updatePeople")

    public Response update(@RequestBody People people){
        if(peoplerService.update(people)){
            return Response.success(null,Msg.UPD_SUCCESS);
        }
        return Response.failure(Msg.UPD_FALIED);
    }
    @RequestMapping("deletePeople")

    public Response del(String list,Integer id){
        if(peoplerService.delete(id)!=0){
            return Response.success(null,Msg.DEL_SUCCESS);
        }
        return Response.failure(Msg.DEL_FALIED);
    }
    @RequestMapping("deleteAllPeople")

    public Response delAll(@RequestBody List<People> list ){
        for (int i = 0; i <list.size() ; i++) {
           if( peoplerService.delete(list.get(i).getId())==null)
               return Response.failure(Msg.UPD_FALIED);
        }

            return Response.success(null,Msg.UPD_SUCCESS);

    }

}
