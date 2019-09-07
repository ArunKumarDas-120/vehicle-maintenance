package com.notify.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.notify.dto.NotificatonDTO;
import com.notify.entity.NotificationMain;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationMain, Integer> {

    @Query(value = "SELECT new com.notify.dto.NotificatonDTO(CONCAT(nm.firstName,' ',nm.lastName) AS userName ,nm.userEmail,"
	    + "CONCAT(vi.vehicleNumber,' ',vi.company,' ',vi.model) AS vehicleInfo,vs.taskName,vs.nextChangeDate) from "
	    + "NotificationMain nm INNER JOIN nm.vehiclesList vi INNER JOIN vi.vehicleScheduleInfo vs "
	    + "WHERE vs.nextChangeDate - CURRENT_DATE = :numberOfDaysLeft")
    public List<NotificatonDTO> getScheduleToNotify(@Param("numberOfDaysLeft") int numberOfDaysLeft);
    
    @Query(value = "SELECT new com.notify.dto.NotificatonDTO(CONCAT(nm.firstName,' ',nm.lastName) AS userName ,nm.userEmail,"
	    + "CONCAT(vi.vehicleNumber,' ',vi.company,' ',vi.model) AS vehicleInfo,vs.taskName,vs.nextChangeDate) from "
	    + "NotificationMain nm INNER JOIN nm.vehiclesList vi INNER JOIN vi.vehicleScheduleInfo vs "
	    + "WHERE vs.nextChangeDate - CURRENT_DATE < 0 ")
    public List<NotificatonDTO> getOverdueSchedule();

}