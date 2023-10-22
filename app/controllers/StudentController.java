package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.students.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.StudentService;

import javax.inject.Inject;
import java.util.List;
public class StudentController extends Controller {
    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public Result getAllStudents(Http.Request request) {
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Student student = Json.fromJson(json, Student.class);
        List<Student> students = studentService.getAllStudents(student);
        return ok(Json.toJson(students));
    }

    public Result getStudentById(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        try {

            Student student = Json.fromJson(json, Student.class);
            Student retrievedStudent = studentService.getStudentById(student);

            if (retrievedStudent != null) {
                return ok(Json.toJson(retrievedStudent));
            } else {
                return notFound("Student not found");
            }
        } catch (Exception e) {
            return internalServerError("Error retrieving student: " + e.getMessage());
        }
    }


    public Result addStudent(Http.Request request) {
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest("Expecting JSON data");
        }

        try {
            // Deserialize JSON into a Student object
            Student student = Json.fromJson(json, Student.class);
            studentService.addStudent(student);
            return ok("Student added successfully");
        } catch (Exception e) {
            return internalServerError("Error adding student: " + e.getMessage());
        }
    }
    public Result getAllClassNames() {
        List<String> classNames = studentService.getAllClassNames();
        ObjectNode responseJson = Json.newObject();
        ArrayNode classArray = responseJson.putArray("classes");

        for (String className : classNames) {
            classArray.add(className);
        }
        return ok(responseJson);
    }
}
