package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.StepChallengePo;

@Mapper
public interface StepChallengeMapper extends BaseMapper<StepChallengePo, String> {

}