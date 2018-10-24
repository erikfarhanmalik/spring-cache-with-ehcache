package com.erik.learn.cachingwithspring.persistent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

	private String isbn;
	private String title;

}
