package com.scheduler;

import com.config.datasource.DataSourceContextHolder;
import com.config.datasource.DataSourceEnum;
import com.domain.entity.*;
import com.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private DataSourceContextHolder holder;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private JournalContentRepository journalContentRepository;

    @Autowired
    private JournalHeaderRepository journalHeaderRepository;

    @Autowired
    private JournalSiteRepository journalSiteRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private TypeClassRepository typeClassRepository;

        @Scheduled(cron = "0 0 11,23 * * *")
    public void replicationTable() {
        replicationElectronicJournalToStudentAccount();
        replicationTimetableToStudentAccount();
    }

    public void replicationElectronicJournalToStudentAccount() {
        holder.setBranchContext(DataSourceEnum.ELECTRONIC_JOURNAL);
        List<Discipline> disciplines = disciplineRepository.findAll();
        List<Group> groups = groupRepository.findAll();
        List<JournalContent> journalContents = journalContentRepository.findAll();
        List<JournalHeader> journalHeaders = journalHeaderRepository.findAll();
        List<JournalSite> journalSites = journalSiteRepository.findAll();
        List<Student> students = studentRepository.findAll();
        List<Teacher> teachers = teacherRepository.findAll();
        List<TypeClass> typeClasses = typeClassRepository.findAll();
        DataSourceContextHolder.clearBranchContext();
        holder.setBranchContext(DataSourceEnum.STUDENT_ACCOUNT);
        disciplineRepository.saveAll(disciplines);
        groupRepository.saveAll(groups);
        studentRepository.saveAll(students);
        teacherRepository.saveAll(teachers);
        typeClassRepository.saveAll(typeClasses);
        journalSiteRepository.saveAll(journalSites);
        journalHeaderRepository.saveAll(journalHeaders);
        journalContentRepository.saveAll(journalContents);
        DataSourceContextHolder.clearBranchContext();
    }

    private void replicationTimetableToStudentAccount() {
        holder.setBranchContext(DataSourceEnum.TIMETABLE);
        List<Timetable> timetables = timetableRepository.findAll();
        DataSourceContextHolder.clearBranchContext();
        holder.setBranchContext(DataSourceEnum.STUDENT_ACCOUNT);
        timetableRepository.saveAll(timetables);
        DataSourceContextHolder.clearBranchContext();
    }
}
