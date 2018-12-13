package com.reactive.playing.reactorplaying.flux;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FluxUppercaseTransformationTest {

    @Test
    public void givenAListOfCapitalizedStrings_WhenTheFlatMapConvertsToUpperCaseTheStrings_ThenTheStringsAreInUpperCase() throws Exception {
        final List<String> namesCapitalized = Arrays.asList("John", "Steve", "Rene");
        final Iterator<String> namesCapitalizedIterator = namesCapitalized.iterator();
        Flux<String> fluxWithNamesCapitalized = Flux.fromIterable
                (namesCapitalized);
        Flux<String> fluxWithNamesInUpperCase = fluxWithNamesCapitalized
                .map(name -> name.toUpperCase());
        fluxWithNamesInUpperCase.subscribe(nameInUpperCase ->
            {
                final String expectedString = namesCapitalizedIterator.next().toUpperCase();
                Assert.assertEquals(expectedString, nameInUpperCase);
            }
        );
    }

}
