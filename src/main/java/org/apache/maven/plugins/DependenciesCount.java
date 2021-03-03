package org.apache.maven.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(defaultPhase = LifecyclePhase.TEST, name = "count")
public class DependenciesCount extends AbstractMojo {

    @Parameter(readonly = true, required = true, defaultValue = "${project}")
    private MavenProject project;

    public void execute()
            throws MojoExecutionException {
        List dependencies = project.getDependencies();
        getLog().info(String.format("'%s' has %d dependencies", project.getArtifactId(), dependencies.size()));
    }

}
