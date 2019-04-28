package com.zjc.bs.service.check;

import com.zjc.bs.entity.check.PracticeSup;
import com.zjc.bs.entity.check.PracticeTeacher;

import java.util.List;
import java.util.function.BinaryOperator;

public interface PracticeService {
    List<PracticeTeacher> getPracticeTeacherByPage(PracticeTeacher practiceTeacher);

    List<PracticeSup> getPracticeSipByPage(PracticeSup practiceSup);

    Boolean addPracticeTeacher(PracticeTeacher practiceTeacher);

    Boolean updatePracticeTeacher(PracticeTeacher practiceTeacher);

    Boolean updatePracticeSup(PracticeSup practiceSup);

    Boolean deletePracticeTeacher(PracticeTeacher practiceTeacher);

    PracticeSup getPracticeSup(PracticeSup practiceSup);

    PracticeTeacher getPracticeTeacher(PracticeTeacher practiceTeacher);


}
