package com.erik.learn.cachingwithspring.service;

import com.erik.learn.cachingwithspring.persistent.model.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CacheableService {

	@Cacheable("rare-book")
	public List<Book> getRareHardToFindBooks() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return IntStream.rangeClosed(1, 5).boxed()
				.map(String::valueOf)
				.map(i -> Book.builder()
						.title("title".concat(i))
						.isbn("isbn".concat(i))
						.build())
				.collect(Collectors.toList());
	}

	@CachePut("rare-book")
	public List<Book> getFreshRareHardToFindBooks() {

		return IntStream.rangeClosed(1, 10).boxed()
				.map(String::valueOf)
				.map(i -> Book.builder()
						.title("title".concat(i))
						.isbn("isbn".concat(i))
						.build())
				.collect(Collectors.toList());
	}

	@CacheEvict("rare-book")
	public void evictRareHardToFindBooks() {

		//evictRareHardToFindBooks
	}
}
