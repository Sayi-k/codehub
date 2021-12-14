package org.core.java8.workout.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("h2o", "co2", "co3", "nacl", "cocl3");
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
		System.out.println("**************************");

		
		Stream.of("h2o", "co2", "co3", "nacl", "cocl3").findFirst().ifPresent(System.out::println);
		System.out.println("**************************");

		
		IntStream.range(1, 5).forEach(System.out::println);
		System.out.println("**************************");

		
		Stream.of("a1", "g4", "b8").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);
		System.out.println("**************************");

		
		Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);
		System.out.println("**************************");

		
		/*
		 * Intermediate operations will only be executed when a terminal operation is
		 * present
		 */
		Stream.of("d2", "c1", "a3", "a2").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));
		System.out.println("**************************");
		
		
		Stream.of("d2", "c1", "a3", "x2")
		.map(s-> {
			System.out.println("map: "+s);
			return s.toUpperCase();
		}).anyMatch(s->{
			System.out.println("anyMatch: "+s);
			return s.startsWith("A");
		});
		System.out.println("**************************");
		
		
		Supplier<Stream<String>> streamSupplier =() -> Stream.of("d2", "c1", "a3", "x2").filter(s->s.startsWith("c"));
		streamSupplier.get().anyMatch(s->true);
		streamSupplier.get().noneMatch(s->true);
		System.out.println("**************************");
		
		
		
		List<Person> persons = Arrays
				.asList(new Person("Param", 32),new Person("Prayag", 22),new Person("Rohit", 23),new Person("Jagan", 32),new Person("Naram", 22));
		List<Person> per = persons
				.stream()
				.filter(p->p.name.startsWith("P"))
				.collect(Collectors.toList());
		System.out.println(per);
		System.out.println("**************************");
		
		
		System.out.println("Collectors.toMap");
		Map<Integer, String> mapP = persons.stream().collect(Collectors.toMap(p->p.age, p->p.name, (n1,n2)->n1+","+n2));
		System.out.println(mapP);
		System.out.println("**************************");
		
		
		Map<Integer, List<Person>> mapGroupBy = persons.stream().collect(Collectors.groupingBy(p->p.age));
		System.out.println(mapGroupBy);
		mapGroupBy.forEach((k,v) -> System.out.format("Age: %s | %s\n", k, v));
		System.out.println("**************************");
		
		
		List<Foo> foos = new ArrayList<>();
		IntStream.range(1, 4).forEach(i->foos.add(new Foo("Foo"+i)));
		foos.forEach(f->IntStream.range(1, 4).forEach(i->f.bars.add(new Bar("Bar"+i+" <- "+f.name))));
		foos.stream().flatMap(f->f.bars.stream()).forEach(b->System.out.println(b.name));
		System.out.println("**************************");
		
		
		foos.clear();
		IntStream.range(1, 4)
		.mapToObj(i->new Foo("Foo"+i))
		.peek(f->IntStream.range(1, 4).mapToObj(i->new Bar("Bar"+i+f.name)).forEach(f.bars::add))
		.flatMap(f->f.bars.stream()).forEach(b->System.out.println(b.name));
		System.out.println("**************************");
		
		
		System.out.println("Optional");
		Integer a = null;
		Integer b = 10;
		Integer sum = Optional.ofNullable(a).orElse(0)+Optional.ofNullable(b).orElse(0);
		System.out.println("Sum = "+sum);
		System.out.println("**************************");
	}

}
