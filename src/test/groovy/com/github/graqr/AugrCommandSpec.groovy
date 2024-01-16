package com.github.graqr

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class AugrCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test Augr with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-v'] as String[]
        PicocliRunner.run(AugrCommand, ctx, args)

        expect:
        baos.toString().contains('Hi!')
    }
}

