package com.appleyk.repository;

import com.appleyk.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 基于电影知识图谱的自问自答的查询接口
 * @author yukun24@126.com
 * @blob   http://blog.csdn.net/appleyk
 * @date   updated by 2020年4月1日-下午23:52:00
 */
public interface QuestionsRepository extends Neo4jRepository<Movie,Long> {

	/**
	 * 0 对应问题模板0 == nm 所属的水域
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回所在的水库
	 */
	@Query("MATCH (n)-[r:`http://water.hhu.edu.cn/ontology/relation#in_bas`]->(m:`http://water.hhu.edu.cn/ontology/schema#BAS`) WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"引流河\" AND (n:`http://water.hhu.edu.cn/ontology/schema#RV` OR n:`http://water.hhu.edu.cn/ontology/schema#RES` OR n:`http://water.hhu.edu.cn/ontology/schema#LK` OR n:`http://water.hhu.edu.cn/ontology/schema#HYST`) RETURN m.`http://www.w3.org/2000/01/rdf-schema#label` LIMIT 25")
	String getInBas(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 1 对应问题模板1 == nm 所在的行政区域
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回所在的行政区域
	 */
	@Query("MATCH (n)-[r:`http://water.hhu.edu.cn/ontology/relation#in_ad`]->(m:`http://water.hhu.edu.cn/ontology/schema#AD`) WHERE (n:`http://water.hhu.edu.cn/ontology/schema#LK` OR n:`http://water.hhu.edu.cn/ontology/schema#RV` OR n:`http://water.hhu.edu.cn/ontology/schema#RES`) AND n.`http://www.w3.org/2000/01/rdf-schema#label`=\"七里海\"  RETURN m.`http://www.w3.org/2000/01/rdf-schema#label` LIMIT 25")
	String getInAd(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 2 对应问题模板2 == rv 流经的区域
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 *
	 * @return 返回河流流经的区域
	 */
	@Query("MATCH (n:`http://water.hhu.edu.cn/ontology/schema#RV`) WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"还乡河\"  RETURN n.`http://water.hhu.edu.cn/ontology/relation#region` LIMIT 25")
	String getRegion(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 3 对应问题模板3 == rv 上游
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回河流的上游
	 */
	@Query("MATCH (n:`http://hhu.waterlogging.cn/conceptNode/RV`)-[r:`http://hhu.waterlogging.cn/conceptProp/up_rv`]->(m:`http://hhu.waterlogging.cn/conceptNode/RV`)  WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"马连川河\"  RETURN m.`http://www.w3.org/2000/01/rdf-schema#label` LIMIT 25")
	String getUpRv(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 4 对应问题模板4 == hyst 所在的水库
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回水电站所在的水库
	 */
	@Query("MATCH (n:`http://water.hhu.edu.cn/ontology/schema#HYST`)-[r:`http://water.hhu.edu.cn/ontology/relation#belongToRES`]->(m:`http://water.hhu.edu.cn/ontology/schema#RES`)  WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"下马岭水电站\"  RETURN m.`http://www.w3.org/2000/01/rdf-schema#label` LIMIT 25")
	String getBeongToRes(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 5 对应问题模板5 == nm 所在的位置
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回所在的地理位置
	 */
	@Query("MATCH (n)  WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"寨地水库主坝\" AND (n:`http://water.hhu.edu.cn/ontology/schema#HYST` OR n:`http://water.hhu.edu.cn/ontology/schema#Dam`)  RETURN n.`http://water.hhu.edu.cn/ontology/relation#loc`  LIMIT 25")
	String getLoc(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 6 对应问题模板6 == nm 的编号
	 *
	 *
	 * @param `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回编号
	 */
	@Query("MATCH (n) WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"子牙河水系\" AND (n:`http://water.hhu.edu.cn/ontology/schema#HYST` OR n:`http://water.hhu.edu.cn/ontology/schema#Dam` OR n:`http://water.hhu.edu.cn/ontology/schema#BAS`)  RETURN n.`http://water.hhu.edu.cn/ontology/relation#code` LIMIT 25")
	String getCode(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);

	/**
	 * 7对应问题模板7 == dam 所在的河流
	 *
	 * `http://www.w3.org/2000/01/rdf-schema#label` 河流或水利设施的名称
	 * @return 返回水坝所在的河流
	 */
	@Query("MATCH (n:`http://water.hhu.edu.cn/ontology/schema#Dam`)-[r:`http://water.hhu.edu.cn/ontology/relation#belongToRV`]->(m:`http://water.hhu.edu.cn/ontology/schema#RV`) WHERE n.`http://www.w3.org/2000/01/rdf-schema#label`=\"蔡家洼水库主坝\"  RETURN m.`http://www.w3.org/2000/01/rdf-schema#label` LIMIT 25")
	String getBelongToRv(@Param("`http://www.w3.org/2000/01/rdf-schema#label`") String label);



}
