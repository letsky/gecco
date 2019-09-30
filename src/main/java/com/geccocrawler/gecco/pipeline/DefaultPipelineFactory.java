package com.geccocrawler.gecco.pipeline;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.spider.SpiderBean;

public class DefaultPipelineFactory implements PipelineFactory {

	private Map<String, Pipeline<? extends SpiderBean>> pipelines;

	public DefaultPipelineFactory(Reflections reflections) {
		this.pipelines = new HashMap<>();
		Set<Class<?>> pipelineClasses = reflections.getTypesAnnotatedWith(PipelineName.class);
		for (Class<?> pipelineClass : pipelineClasses) {
			PipelineName spiderFilter = pipelineClass.getAnnotation(PipelineName.class);
			try {
				pipelines.put(spiderFilter.value(), (Pipeline<? extends SpiderBean>) pipelineClass.newInstance());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public Pipeline<? extends SpiderBean> getPipeline(String name) {
		return pipelines.get(name);
	}

}
