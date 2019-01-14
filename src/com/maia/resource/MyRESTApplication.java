package com.maia.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyRESTApplication extends Application{
	
	private Set<Object>singletons = new HashSet<>();
	
	public MyRESTApplication() {
		singletons.add(new EnderecoResource());
		singletons.add(new FuncionarioResource());
	}
	
	@Override
	public Set<Object>getSingletons(){
		return singletons;
	}

}
