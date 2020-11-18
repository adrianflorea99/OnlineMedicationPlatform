package Service;

import ro.tuc.ds2020.MainTestConfig;
//import DTO.PersonDTO;
//import DTO.PersonDetailsDTO;


//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/create.sql")
//@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/delete.sql")
public class PatientServiceIntegrationTests extends MainTestConfig {

    /*@Autowired
    PersonService personService;

    @Test
    public void testGetCorrect() {
        List<PersonDTO> personDTOList = personService.findPersons();
        assertEquals("Test Insert Person", 1, personDTOList.size());
    }

    @Test
    public void testInsertCorrectWithGetById() {
        PersonDetailsDTO p = new PersonDetailsDTO("John", "Somewhere Else street", 22);
        UUID insertedID = personService.insert(p);

        PersonDTO insertedPerson = new PersonDTO(insertedID, p.getName(), p.getAge());
        PersonDTO fetchedPerson = personService.findPersonById(insertedID);

        assertEquals("Test Inserted Person", insertedPerson, fetchedPerson);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        PersonDetailsDTO p = new PersonDetailsDTO("John", "Somewhere Else street", 22);
        personService.insert(p);

        List<PersonDTO> personDTOList = personService.findPersons();
        assertEquals("Test Inserted Persons", 2, personDTOList.size());
    }*/
}
