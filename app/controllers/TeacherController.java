package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.teachers.Teacher;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.TeacherService;

import javax.inject.Inject;
import java.util.List;

public class TeacherController extends Controller {
    private final TeacherService teacherService;

    @Inject
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public Result addTeacher(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        try {
            Teacher teacher = Json.fromJson(json, Teacher.class);
            teacherService.addTeacher(teacher);
            return ok("Teacher added successfully");
        } catch (Exception e) {
            return internalServerError("Error adding teacher: " + e.getMessage());
        }
    }

    public Result getTeacherById(int teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if (teacher != null) {
            return ok(Json.toJson(teacher));
        } else {
            return notFound("Teacher not found");
        }
    }

    public Result getAllTeachers() {
        List<Teacher> teacherList = teacherService.getAllTeachers();

        if (!teacherList.isEmpty()) {
            return ok(Json.toJson(teacherList));
        } else {
            return notFound("No teachers found");
        }
    }
}
