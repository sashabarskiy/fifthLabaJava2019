package ua.com.radmirtech.lora.app.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ua.com.radmirtech.lora.app.entity.GroupEntity;
import ua.com.radmirtech.lora.app.entity.StudentEntity;
import ua.com.radmirtech.lora.app.model.StudentModel;
import ua.com.radmirtech.lora.app.service.Service;

import java.util.List;

public class Controller {

    @FXML
    private TableView<GroupEntity> tableViewGroups;

    @FXML
    private TableColumn<GroupEntity, Long> idGroupColumn;

    @FXML
    private TableColumn<GroupEntity, String> nameGroupColumn;

    @FXML
    private TableView<StudentModel> tableViewStudents;

    @FXML
    private TableColumn<StudentModel, Long> idStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> nameStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> surnameStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> groupStudentColumn;

    @FXML
    private TableColumn<StudentModel, Integer> markStudentColumn;

    @FXML
    private TextField nameGroupTextField;

    @FXML
    private TextField idGroupTextField;

    @FXML
    private TextField nameStudentTextField;

    @FXML
    private TextField idStudentTextField;

    @FXML
    private TextField surnameStudentTextField;

    @FXML
    private TextField markStudentTextField;

    @FXML
    private ComboBox groupStudentComboBox;

    @FXML
    private TableView<StudentModel> tableGoodViewStudents;

    @FXML
    private TableColumn<StudentModel, Long> idGoodStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> nameGoodStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> surnameGoodStudentColumn;

    @FXML
    private TableColumn<StudentModel, String> groupGoodStudentColumn;

    @FXML
    private TableColumn<StudentModel, Integer> markGoodStudentColumn;

    // @Autowired
    // GroupRepository groupRepository;

    // @Autowired
    // StudentRepository studentRepository;

    ObservableList<GroupEntity> convertGroups(List<GroupEntity> list){
        ObservableList<GroupEntity> observable = FXCollections.observableArrayList();
        observable.addAll(list);
        return observable;
    }

    ObservableList<String> convertGroupsNames(List<GroupEntity> list){
        ObservableList<String> observable = FXCollections.observableArrayList();
        for(GroupEntity groupEntity: list)
            observable.add(groupEntity.getName());
        return observable;
    }

    ObservableList<StudentModel> convertStudents(List<StudentModel> list){
        ObservableList<StudentModel> observable = FXCollections.observableArrayList();
        observable.addAll(list);
        return observable;
    }

    @FXML
    public void initialize(){

        System.out.println("start!!!");

        // groups
        idGroupColumn.setCellValueFactory(new PropertyValueFactory<GroupEntity, Long>("id"));
        nameGroupColumn.setCellValueFactory(new PropertyValueFactory<GroupEntity, String>("name"));
        List<GroupEntity> groupEntities = Service.groupRepository.findAll();
        tableViewGroups.setItems(convertGroups(groupEntities));
        groupStudentComboBox.setItems(convertGroupsNames(groupEntities));

        // students

        idStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, Long>("id"));
        nameStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("name"));
        surnameStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("surname"));
        groupStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("group"));
        markStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, Integer>("mark"));
        tableViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAll())));

        // good students

        idGoodStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, Long>("id"));
        nameGoodStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("name"));
        surnameGoodStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("surname"));
        groupGoodStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, String>("group"));
        markGoodStudentColumn.setCellValueFactory(new PropertyValueFactory<StudentModel, Integer>("mark"));
        tableGoodViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAllGood())));

    }

    @FXML
    private void createGroupHandleButtonAction(ActionEvent event) {
        Service.groupRepository.save(new GroupEntity(0L,nameGroupTextField.getText().trim()));
        List<GroupEntity> groupEntities = Service.groupRepository.findAll();
        tableViewGroups.setItems(convertGroups(groupEntities));
        groupStudentComboBox.setItems(convertGroupsNames(groupEntities));
    }

    @FXML
    private void deleteGroupHandleButtonAction(ActionEvent event) {
        Service.groupRepository.delete(Long.parseLong(idGroupTextField.getText().trim()));
        List<GroupEntity> groupEntities = Service.groupRepository.findAll();
        tableViewGroups.setItems(convertGroups(groupEntities));
        groupStudentComboBox.setItems(convertGroupsNames(groupEntities));
    }

    @FXML
    private void updateGroupHandleButtonAction(ActionEvent event) {
        GroupEntity groupEntity = Service.groupRepository.findOne(Long.parseLong(idGroupTextField.getText().trim()));
        groupEntity.setName(nameGroupTextField.getText().trim());
        Service.groupRepository.save(groupEntity);
        List<GroupEntity> groupEntities = Service.groupRepository.findAll();
        tableViewGroups.setItems(convertGroups(groupEntities));
        groupStudentComboBox.setItems(convertGroupsNames(groupEntities));
    }

    @FXML
    private void deleteStudentHandleButtonAction(ActionEvent event) {
        Service.studentRepository.delete(Long.parseLong(idStudentTextField.getText().trim()));
        tableViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAll())));
        tableGoodViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAllGood())));
    }

    @FXML
    private void updateStudentHandleButtonAction(ActionEvent event) {
        StudentEntity studentEntity = Service.studentRepository.findOne(Long.parseLong(idStudentTextField.getText().trim()));
        studentEntity.setName(nameStudentTextField.getText().trim());
        studentEntity.setSurname(surnameStudentTextField.getText().trim());
        studentEntity.setGroup(Service.groupRepository.findByName(groupStudentComboBox.getValue().toString()).get(0).getId());
        studentEntity.setMark(Integer.parseInt(markStudentTextField.getText().trim()));
        Service.studentRepository.save(studentEntity);
        tableViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAll())));
        tableGoodViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAllGood())));
    }

    @FXML
    private void createStudentHandleButtonAction(ActionEvent event) {
        Service.studentRepository.save(new StudentEntity(0L,
                        nameStudentTextField.getText().trim(),
                        surnameStudentTextField.getText().trim(),
                        Service.groupRepository.findByName(groupStudentComboBox.getValue().toString()).get(0).getId(),
                        Integer.parseInt(markStudentTextField.getText().trim())));


        tableViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAll())));
        tableGoodViewStudents.setItems(convertStudents(Service.convertEntityListToModelList(Service.studentRepository.findAllGood())));
    }


}
