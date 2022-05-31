package dev.brianmviana.hexaarch.architecture

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.GeneralCodingRules

@AnalyzeClasses(packages = ["dev.brianmviana"])
class JodaTimeTest {

    @ArchTest
    var dontUseJodaTime: ArchRule = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME

}