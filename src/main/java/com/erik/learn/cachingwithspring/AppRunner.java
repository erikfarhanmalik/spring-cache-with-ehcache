package com.erik.learn.cachingwithspring;

import com.erik.learn.cachingwithspring.persistent.model.Book;
import com.erik.learn.cachingwithspring.service.CacheableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppRunner implements CommandLineRunner {

	private final CacheableService cacheableService;

	@Override
	public void run(String... args)  {
		IntStream.range(0, 3).forEach(i -> {
			log.info("fetch ...");
			int size = cacheableService.getRareHardToFindBooks().size();
			log.info("Size of rare-book: {}", size);
		});

		List<Book> freshRareHardToFindBooks = cacheableService.getFreshRareHardToFindBooks();
		log.info("freshRareHardToFindBooks: {}", freshRareHardToFindBooks.size());

		IntStream.range(0, 3).forEach(i -> {
			log.info("fetch ...");
			int size = cacheableService.getRareHardToFindBooks().size();
			log.info("Size of rare-book: {}", size);
		});

		cacheableService.evictRareHardToFindBooks();
		log.info("evictRareHardToFindBooks()");

		IntStream.range(0, 3).forEach(i -> {
			log.info("fetch ...");
			int size = cacheableService.getRareHardToFindBooks().size();
			log.info("Size of rare-book: {}", size);
		});
	}
}
