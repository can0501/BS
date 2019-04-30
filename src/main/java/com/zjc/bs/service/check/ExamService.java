package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.ExamSup;
import com.zjc.bs.entity.check.ExamTeacher;

import java.util.List;

public interface ExamService {
    List<ExamTeacher> getExamTeacherByPage(ExamTeacher ExamTeacher);

    List<ExamSup> getExamSupByPage(ExamSup ExamSup);

    Boolean addExamTeacher(ExamTeacher ExamTeacher);

    Boolean updateExamTeacher(ExamTeacher ExamTeacher);

    Boolean updateExamSup(ExamSup ExamSup);

    Boolean deleteExamTeacher(ExamTeacher ExamTeacher);

    ExamSup getExamSup(ExamSup ExamSup);

    ExamTeacher getExamTeacher(ExamTeacher ExamTeacher);
}
