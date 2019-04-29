package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.BigHouseWordSup;
import com.zjc.bs.entity.check.BigHouseWordTeacher;

import java.util.List;

public interface BigHouseWordService {
    List<BigHouseWordTeacher> getBigHouseWordTeacherByPage(BigHouseWordTeacher bigHouseWordTeacher);

    List<BigHouseWordSup> getBigHouseWordSupByPage(BigHouseWordSup bigHouseWordSup);

    Boolean addBigHouseWordTeacher(BigHouseWordTeacher bigHouseWordTeacher);

    Boolean updateBigHouseWordTeacher(BigHouseWordTeacher bigHouseWordTeacher);

    Boolean updateBigHouseWordSup(BigHouseWordSup bigHouseWordSup);

    Boolean deleteBigHouseWordTeacher(BigHouseWordTeacher bigHouseWordTeacher);

    BigHouseWordSup getBigHouseWordSup(BigHouseWordSup bigHouseWordSup);

    BigHouseWordTeacher getBigHouseWordTeacher(BigHouseWordTeacher bigHouseWordTeacher);

}
