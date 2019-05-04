package com.zjc.bs.service.estimate;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zjc.bs.entity.estimate.EstimateSup;
import com.zjc.bs.entity.estimate.EstimateTeacher;

import java.util.List;

public interface EstimateService {
    EstimateTeacher getEstimateTeacher(EstimateTeacher estimateTeacher);

    EstimateSup getEstimateSup(EstimateSup estimateSup);

    List<EstimateTeacher> getEstimateTeacherByPage(EstimateTeacher estimateTeacher);

    List<EstimateSup> getEstimateSupByPage(EstimateSup estimateSup);

    Boolean addEstimateTeacher(EstimateTeacher estimateTeacher);

    Boolean updateEstimateTeacher(EstimateTeacher estimateTeacher);

    Boolean updateEstimateSup(EstimateSup estimateSup);

    Boolean deleteEstimateTeacher(EstimateTeacher estimateTeacher);
}
