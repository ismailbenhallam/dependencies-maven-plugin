package org.apache.maven.plugins;

import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(defaultPhase = LifecyclePhase.TEST, name = "list")
public class DependenciesList extends AbstractMojo {

    @Parameter(readonly = true, required = true, defaultValue = "${project}")
    private MavenProject project;

    public void execute()
        throws MojoExecutionException {
        List<Dependency> dependencies = project.getDependencies();
        getLog().info("Project's dependencies :");
        for (Dependency d : dependencies) {
            getLog().info(d.getArtifactId());
        }
    }
}
