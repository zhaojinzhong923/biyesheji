package com.appleyk.service.impl;

import com.appleyk.core.waterCoreProcessor;
import com.appleyk.repository.QuestionRepository;
import com.appleyk.repository.QuestionsRepository;
import com.appleyk.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>核心问答业务实现类</p>
 *
 * @author Appleyk
 * @version V.0.1.2
 * @blob https://blog.csdn.net/Appleyk
 * @date updated on 21:21 2020/3/31
 */
@Service
@Primary
public class QuesServiceImpl implements QuestionService {

    @Autowired
    private QuestionsRepository questionRepository;

    @Autowired
    private waterCoreProcessor waterqueryProcess;

    @Override
    public String answer(String question) throws Exception {

        List<String> reStrings = waterqueryProcess.analysis(question);
        int modelIndex = Integer.valueOf(reStrings.get(0));
        String answer = null;
        String title;
        String name;
        String label = reStrings.get(1);

        /**匹配问题模板*/
        switch (modelIndex) {
            case 0:
                answer = questionRepository.getInBas(label);
                break;
            case 1:
                answer = questionRepository.getInAd(label);
                break;
            case 2:
                answer = questionRepository.getRegion(label);
                break;
            case 3:
                /** rv 上游*/
                answer = questionRepository.getUpRv(label);
                break;
            case 4:
                answer = questionRepository.getBeongToRes(label);
                break;
            case 5:
                /** 地理位置*/
                answer = questionRepository.getLoc(label);
                break;
            case 6:
                answer = questionRepository.getCode(label);
                break;
            case 7:
                /** 所属的河流*/
                answer = questionRepository.getBelongToRv(label);
                break;

            default:
                break;
        }
        System.out.println(answer);
        if (answer != null && !"".equals(answer) && !("\\N").equals(answer)) {
            return answer;
        } else {
            return "sorry,小主,我没有找到你要的答案";
        }
    }
}


