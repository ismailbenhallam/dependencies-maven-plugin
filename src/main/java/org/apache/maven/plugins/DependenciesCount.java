package org.apache.maven.plugins;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

@Mojo(defaultPhase = LifecyclePhase.COMPILE, name = "count")
public class DependenciesCount extends AbstractMojo {

    @Parameter(readonly = true, required = true, defaultValue = "${project}")
    private MavenProject project;

    public void execute()
        throws MojoExecutionException {
        List dependencies = project.getDependencies();
        getLog().info(String.format("'%s' has %d dependencies",project.getArtifactId(), dependencies.size()));
    }

    public static void main(String[] args) {
        final Class<?> proxyClass = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), List.class);
        System.out.println(proxyClass.getName());
    }
}
