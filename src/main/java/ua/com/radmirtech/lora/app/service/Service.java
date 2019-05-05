package ua.com.radmirtech.lora.app.service;

import ua.com.radmirtech.lora.app.entity.StudentEntity;
import ua.com.radmirtech.lora.app.model.StudentModel;
import ua.com.radmirtech.lora.app.repository.GroupRepository;
import ua.com.radmirtech.lora.app.repository.StudentRepository;

import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    public static GroupRepository groupRepository;

    public static StudentRepository studentRepository;

    public Service(GroupRepository groupRepository, StudentRepository studentRepository){
        Service.groupRepository = groupRepository;
        Service.studentRepository = studentRepository;
    }

    static public StudentModel convertEntityToModel(StudentEntity studentEntity){
          return new StudentModel(
                  studentEntity.getId(),
                  studentEntity.getName(),
                  studentEntity.getSurname(),
                  groupRepository.findOne(
                          studentEntity.getGroup()
                  ).getName(),
                  studentEntity.getMark()
          );
    }

    static public List<StudentModel> convertEntityListToModelList(List<StudentEntity> entityList){
        List<StudentModel> modelList = new LinkedList<StudentModel>();
        for(StudentEntity studentEntity: entityList)
            modelList.add(convertEntityToModel(studentEntity));
        return modelList;
    }


}
