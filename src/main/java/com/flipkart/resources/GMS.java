package com.flipkart.resources;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class GMS extends Application<GMSConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GMS().run(args);
    }
    @Override
    public void run(GMSConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(LoginResource.class);
        environment.jersey().register(AdminResource.class);
        environment.jersey().register(CustomerResource.class);
        environment.jersey().register(GymOwnerResource.class);
    }
}
