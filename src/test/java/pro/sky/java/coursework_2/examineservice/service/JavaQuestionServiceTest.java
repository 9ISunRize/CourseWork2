package pro.sky.java.coursework_2.examineservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.coursework_2.examineservice.domain.Question;
import pro.sky.java.coursework_2.examineservice.repository.JavaQuestionRepository;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static pro.sky.java.coursework_2.examineservice.service.constants.ConstantsQuestionService.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository repository;

    @InjectMocks
    JavaQuestionService service;

    @Test
    public void whenAddElementThenEqualsExpectElement() {
        when(repository.add(any())).thenReturn(QUESTION_OBJ1);
        assertEquals(QUESTION_OBJ1, service.add(QUESTION1, ANSWER1));
    }
    @Test
    public void whenAddElementQuestionThenEqualsExpectElement() {
        when(repository.add(any())).thenReturn(QUESTION_OBJ1);
        assertEquals(QUESTION_OBJ1, service.add(QUESTION_OBJ1));
    }

    @Test
    public void whenRemoveOneQuestionThenEqualsExpectElement() {
        when(repository.remove(any())).thenReturn(QUESTION_OBJ1);
        assertEquals(QUESTION_OBJ1, service.remove(QUESTION_OBJ1));
    }

    @Test
    public void whenGetRandomQuestionThenContainInSet() {
        when(repository.getAll()).thenReturn(QUESTIONS_ALL);
        assertTrue(QUESTIONS_ALL.contains(service.getRandomQuestion()));
    }

    @Test
    public void whenGetRandomQuestionThenEqualsSet() {
        when(repository.getAll()).thenReturn(QUESTIONS_ALL);
        Set<Question> set = IntStream.range(0, AMOUNT_FOR_GET_RANDOM_QUESTION)
                .mapToObj(i -> service.getRandomQuestion())
                .collect(Collectors.toSet());
        assertThat(set).containsExactlyInAnyOrderElementsOf(QUESTIONS_ALL);
    }

    @Test
    public void whenGetRandomQuestionThenEqualsSetAmount() {
        when(repository.getAll()).thenReturn(QUESTIONS_ALL);
        Set<Question> set = IntStream.range(0, AMOUNT)
                .mapToObj(i -> service.getRandomQuestion())
                .collect(Collectors.toSet());
        assertThat(set).containsExactlyInAnyOrderElementsOf(QUESTIONS_ALL);
    }
}