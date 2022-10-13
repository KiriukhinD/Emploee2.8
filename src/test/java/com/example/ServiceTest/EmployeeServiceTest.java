package com.example.ServiceTest;

import com.example.Service.EmployeeService;
import com.example.Service.ValidatorService;
import com.example.homework2_8.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class EmployeeServiceTest {

    private final EmployeeService employeeService = new EmployeeService(new ValidatorService());

    public static Stream<Arguments> addNegativ1Params() {
        return Stream.of(

                Arguments.of("Ivan1", "Ivanov", IncorrectNameException.class));
    }

    @AfterEach
    public void afterEach() {
        employeeService.getAll().forEach(employee -> employeeService.remove(employee.getName(), employee.getSurname()));
    }

    @Test
    public void addPozitivTest() {
        Employee expected = new Employee("Ivan", "Ivanov", 1, 20_500);
        assertThat(employeeService.getAll()).isEmpty();
        employeeService.add(expected.getName(), expected.getSurname(), expected.getDepartment(), expected.getSalary());
        assertThat(employeeService.getAll())
                .isNotEmpty()
                .hasSize(1)
                .containsExactly(expected);
        assertThat(employeeService.find(expected.getName(), expected.getSurname())).isEqualTo(expected);

    }

    @ParameterizedTest
    @MethodSource("addNegativ1Params")
    @Test
    public void addNegativ1Test(String name,
                                String surname,
                                Class<Throwable> expectedExeptionType) {
        assertThatExceptionOfType(expectedExeptionType)
                .isThrownBy(() -> employeeService.add(name, surname, 1, 20_500));

    }


}
