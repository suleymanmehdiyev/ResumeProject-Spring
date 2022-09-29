package com.company;

import com.company.config.Config;
import com.company.dao.inter.UserDAOInter;
import com.company.model.*;
import com.company.repository.UserRepository;
import com.company.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

//	@Autowired
//	private UserDAOInter userDAO;

//	@Autowired
//	private UserRepository userRepository;

//	@Autowired
//	private UserServiceInter userServiceInter;

//	@Autowired
//	private UniversityServiceInter universityServiceInter;
//
//	@Autowired
//	private UserSkillServiceInter userSkillServiceInter;

//	@Autowired
//	private SkillServiceInter skillServiceInter;
//
//	@Autowired
//	private EmploymentHistoryServiceInter employmentHistoryServiceInter;

	@Autowired
	private EducationServiceInter educationServiceInter;

	@Autowired
	private ContactDetailServiceInter contactDetailServiceInter;

	@Autowired
	private CityServiceInter cityServiceInter;


	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}
//
//	@Bean
//	public CommandLineRunner run(){
//	 CommandLineRunner clr = new CommandLineRunner() {
//		 @Override
//		 public void run(String... args) throws Exception {
//			 List<User> list = userDAO.getAll();
////			 System.out.println(list);
//			 User user = new User(1,"Suleyman","Mehdiyev","smehdiyev939@gmail.com","12345678");
////			 userDAO.addUser(user);
////			 userDAO.updateUser(user);
////			 System.out.println(userDAO.getById(1));
//			 System.out.println(userDAO.findByUserEmail("smehdiyev939@gmail.com"));
//		 }
//	 };
//		return clr;


	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
//				List<User> users = userServiceInter.getAll();
//				Optional<User> user = userServiceInter.getById(1);
//				User user = new User(null,"Chinar","Abbasova","khanchinar7@gmail.com","12345678");
//				userServiceInter.addUser(user);
//				System.out.println(userServiceInter.findByUserEmail("khanchinar7@gmail.com"));

//				UserSkill userSkill = new UserSkill(1,new Skill(1),new User(1));
//				System.out.println(userSkillServiceInter.getAllUserSkill(new User(1)));
//				userSkillServiceInter.updateUserSkill(userSkill);

//				University uni = new University(null,"Baki Dovlet Universiteti");
////				universityServiceInter.addUniversity(uni);
//				universityServiceInter.deleteUniversity(2);
//				System.out.println(universityServiceInter.getById(1));

//				Skill skill = new Skill(3,"C#");
//				skillServiceInter.updateSkill(skill);
//				System.out.println(skillServiceInter);

//				EmploymentHistory employmentHistory = new EmploymentHistory(1,new Date(2022-10-10),"Galactechhhhhh",new Date(2022-02-02),"back end developer","developer",new User(1));
////				employmentHistoryServiceInter.updateEmploymentHistory(employmentHistory);
//				employmentHistoryServiceInter.deleteEmploymentHistoryById(3);
//				System.out.println(employmentHistoryServiceInter.getAllEmploymentHistory(new User(1)));
//				Date sqlDate = new Date(2022-12-12);
//				String date = "2022-12-12";
//				System.out.println(Config.parseDate(new Date(2022-12-12).toString()));


//				Education education = new Education(1,"Master","Optotexnikaaa",new Date(2022-12-12),new Date(2022-12-12),new University(3),new User(1));
//				educationServiceInter.updateEducation(education);

//				ContactDetail contactDetail = new ContactDetail(1,"+994554962960","general Sixlinski 15",new City(2),new User(1));
//				System.out.println(contactDetailServiceInter.getContactDetailById(new User(1)));

				City city = new City(3,"Agcabedi");
				cityServiceInter.updateCity(city);
				cityServiceInter.deleteCity(3);

			}
		};
		return clr;
	}
}
