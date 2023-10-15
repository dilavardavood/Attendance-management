package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.attendance.Attendance;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.AttendanceService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AttendanceController extends Controller {
    private final AttendanceService attendanceService;

    @Inject
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    public Result addAttendance(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        try {
            Attendance attendance = Json.fromJson(json, Attendance.class);
            attendanceService.addAttendance(attendance);
            return ok("Attendance added successfully");
        } catch (Exception e) {
            return internalServerError("Error adding attendance: " + e.getMessage());
        }
    }

    // Add a new method for bulk uploading attendance
    public Result addBulkAttendance(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null || !json.isArray()) {
            return badRequest("Expecting an array of attendance records in JSON format");
        }

        try {
            List<Attendance> attendanceList = new ArrayList<>();
            for (JsonNode node : json) {
                Attendance attendance = Json.fromJson(node, Attendance.class);
                attendanceList.add(attendance);
            }

            attendanceService.addBulkAttendance(attendanceList);
            return ok("Attendance added successfully");
        } catch (Exception e) {
            return internalServerError("Error adding attendance: " + e.getMessage());
        }
    }

    public Result getAttendanceByRollNo(Http.Request request) {
        JsonNode json = request.body().asJson();
        Attendance attendance = Json.fromJson(json,Attendance.class);
        List<Attendance> attendanceList = attendanceService.getAttendanceByRollNo(attendance);

        if (!attendanceList.isEmpty()) {
            return ok(Json.toJson(attendanceList));
        } else {
            return notFound("No attendance records found for the provided roll number");
        }
    }
}
