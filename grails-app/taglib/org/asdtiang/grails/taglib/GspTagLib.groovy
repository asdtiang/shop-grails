package org.asdtiang.grails.taglib
import org.springframework.context.NoSuchMessageException
import org.springframework.context.MessageSourceResolvable
import org.springframework.validation.FieldError
import org.springframework.web.servlet.support.RequestContextUtils as RCU

class GspTagLib {
    def renderErrors = { attrs, body ->
        def bean = attrs.bean;
        out << "<ul>";
        //in controller
        //def messageSource = grailsApplication.getMainContext().getBean("messageSource");
        //in taglib
        def messageSource = grailsAttributes.getApplicationContext().getBean("messageSource");
        bean.errors.getAllErrors().each {error ->
            if (error.class.name == 'org.springframework.validation.FieldError') {
                def args = error.getArguments();
                def field = bean.class.getDeclaredField(error.field);
                if (field.getAnnotation(org.asdtiang.grails.annotation.Title)) {
                    args[0] = field.getAnnotation(org.asdtiang.grails.annotation.Title).value();
                }
                if (args.length > 1) {
                    if (bean.class.getAnnotation(org.asdtiang.grails.annotation.Title)) {
                        args[1] = bean.class.getAnnotation(org.asdtiang.grails.annotation.Title).value();
                    }
                }
                def newerror = new FieldError(error.objectName,
                        error.field, error.rejectedValue,
                        error.isBindingFailure(),
                        error.codes, args, error.defaultMessage);
                out << "<li>" + messageSource.getMessage(newerror,
                        RCU.getLocale(request)) + '</li>';
            }
        }
        out << "</ul>"
    }
}
