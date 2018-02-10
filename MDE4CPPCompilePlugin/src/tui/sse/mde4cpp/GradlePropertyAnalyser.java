package tui.sse.mde4cpp;

import org.gradle.api.Project;

class GradlePropertyAnalyser
{
	static String getParallelJobsFlag(Project project)
	{
		if (project.hasProperty("make_parallel_jobs"))
		{
			return " -j" + project.property("make_parallel_jobs");
		}
		else
		{
			return "";
		}
	}

	static boolean isDebugBuildModeRequestet(Project project)
	{
		return (project.hasProperty("DEBUG") && (!project.property("DEBUG").equals("0"))) || (project.hasProperty("D") && (!project.property("D").equals("0")))
				|| (!project.hasProperty("RELEASE") && !project.hasProperty("R") && !project.hasProperty("DEBUG") && !project.hasProperty("D"));
	}

	static boolean isReleaseBuildModeRequested(Project project)
	{
		return (project.hasProperty("RELEASE") && (!project.property("RELEASE").equals("0"))) || (project.hasProperty("R") && (!project.property("R").equals("0")))
				|| (!project.hasProperty("RELEASE") && !project.hasProperty("R") && !project.hasProperty("DEBUG") && !project.hasProperty("D"));
	}

	static boolean isExecutionBuildRequested(Project project)
	{
		return (project.hasProperty("EXECUTION") && (!project.property("EXECUTION").equals("0"))) || (project.hasProperty("E") && (!project.property("E").equals("0")))
				|| (!project.hasProperty("STRUCTURE") && !project.hasProperty("S") && !project.hasProperty("EXECUTION") && !project.hasProperty("E"));
	}

	static boolean isStructureBuildRequested(Project project)
	{
		return (project.hasProperty("STRUCTURE") && (!project.property("STRUCTURE").equals("0"))) || (project.hasProperty("S") && (!project.property("S").equals("0")))
				|| (!project.hasProperty("STRUCTURE") && !project.hasProperty("S") && !project.hasProperty("EXECUTION") && !project.hasProperty("E"));
	}
}
