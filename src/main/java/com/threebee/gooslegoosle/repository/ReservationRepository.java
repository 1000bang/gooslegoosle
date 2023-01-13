package com.threebee.gooslegoosle.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.threebee.gooslegoosle.dto.ChartMonthDTO;
import com.threebee.gooslegoosle.dto.ChartSixMonthDTO;


@Repository
public class ReservationRepository {

	
	private final EntityManager entityManager;

	public ReservationRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	public List<ChartMonthDTO> getChartWeekly(int id) {
		
		String query = " SELECT DATE_FORMAT(DATE_SUB(date, INTERVAL (DAYOFWEEK(date)-1) DAY), '%Y/%m/%d') as 'start', "
				+ "       DATE_FORMAT(DATE_SUB(date, INTERVAL (DAYOFWEEK(date)-7) DAY), '%Y/%m/%d') as 'end', "
				+ "       DATE_FORMAT(date, '%Y%U') as 'format', "
				+ "	   		count(date) as count "
				+ "        "
				+ " FROM gooslegoosle.ReservationEntity "
				+ " WHERE  "
				+ "			    storeid = " +id 
				+ "			 AND(date BETWEEN DATE_ADD(NOW(), INTERVAL -1 MONTH ) AND NOW()) "
				+ " GROUP BY format "
				+ " ORDER BY start ";
		
		Query nativeQuery = entityManager.createNativeQuery(query);
		List<Object[]> data = nativeQuery.getResultList();
		List<ChartMonthDTO> chart = new ArrayList<>();
		ChartMonthDTO temp = null;
		for (int i = 0; i < data.size(); i++) {
			Object[] obj = data.get(i);
			for (int j = 0; j < obj.length; j++) {
				 temp = new ChartMonthDTO(obj);
				
			}
			chart.add(temp);
		}
		System.out.println(">>>>>>>" + temp);
		
		
		return chart;
	}
	
	public List<ChartSixMonthDTO> getChartMonthly(int id) {
		
	
	String query = "SELECT MONTH(date) AS 'month', "
			+ "       count(*) "
			+ " FROM gooslegoosle.ReservationEntity "
			+ " WHERE  "
			+ " storeid = " + id
			+ " AND(date BETWEEN DATE_ADD(NOW(), INTERVAL -6 MONTH ) AND NOW()) "
			+ " GROUP BY month"
			+ " ORDER BY month ";
	
	Query nativeQuery = entityManager.createNativeQuery(query);
	List<Object[]> data = nativeQuery.getResultList();
	List<ChartSixMonthDTO> chart = new ArrayList<>();
	ChartSixMonthDTO temp = null;
	for (int i = 0; i < data.size(); i++) {
		Object[] obj = data.get(i);
		for (int j = 0; j < obj.length; j++) {
			 temp = new ChartSixMonthDTO(obj);
			
		}
		chart.add(temp);
	}
	
		return chart;
	}
}
