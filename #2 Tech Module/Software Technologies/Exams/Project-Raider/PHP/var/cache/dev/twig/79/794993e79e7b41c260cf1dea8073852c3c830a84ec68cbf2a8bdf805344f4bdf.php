<?php

/* @Twig/Exception/exception_full.html.twig */
class __TwigTemplate_237ff2a1e63d63cd1d0c80b7dcb8957f3d313ef90d0e7788debff48edc841ff3 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@Twig/layout.html.twig", "@Twig/Exception/exception_full.html.twig", 1);
        $this->blocks = array(
            'head' => array($this, 'block_head'),
            'title' => array($this, 'block_title'),
            'body' => array($this, 'block_body'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@Twig/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_6213bb5421601a809e28bd1e3e6ee84d3a5ecede392118eb339e7bd7a325f0ae = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_6213bb5421601a809e28bd1e3e6ee84d3a5ecede392118eb339e7bd7a325f0ae->enter($__internal_6213bb5421601a809e28bd1e3e6ee84d3a5ecede392118eb339e7bd7a325f0ae_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/Exception/exception_full.html.twig"));

        $__internal_be545d2459a493b2cb40132c188d4377d32641f030908f594894215ad65d1cda = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_be545d2459a493b2cb40132c188d4377d32641f030908f594894215ad65d1cda->enter($__internal_be545d2459a493b2cb40132c188d4377d32641f030908f594894215ad65d1cda_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/Exception/exception_full.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_6213bb5421601a809e28bd1e3e6ee84d3a5ecede392118eb339e7bd7a325f0ae->leave($__internal_6213bb5421601a809e28bd1e3e6ee84d3a5ecede392118eb339e7bd7a325f0ae_prof);

        
        $__internal_be545d2459a493b2cb40132c188d4377d32641f030908f594894215ad65d1cda->leave($__internal_be545d2459a493b2cb40132c188d4377d32641f030908f594894215ad65d1cda_prof);

    }

    // line 3
    public function block_head($context, array $blocks = array())
    {
        $__internal_4ef147cd91eae2d3230359beb774da0637c11c86f97bbe610465911c7784ee7f = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_4ef147cd91eae2d3230359beb774da0637c11c86f97bbe610465911c7784ee7f->enter($__internal_4ef147cd91eae2d3230359beb774da0637c11c86f97bbe610465911c7784ee7f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        $__internal_a9c88b30c63530c999e8b9a8b17bd9899b3371e15723d73607bbd58281edda9b = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_a9c88b30c63530c999e8b9a8b17bd9899b3371e15723d73607bbd58281edda9b->enter($__internal_a9c88b30c63530c999e8b9a8b17bd9899b3371e15723d73607bbd58281edda9b_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        // line 4
        echo "    <style>
        .sf-reset .traces {
            padding-bottom: 14px;
        }
        .sf-reset .traces li {
            font-size: 12px;
            color: #868686;
            padding: 5px 4px;
            list-style-type: decimal;
            margin-left: 20px;
        }
        .sf-reset #logs .traces li.error {
            font-style: normal;
            color: #AA3333;
            background: #f9ecec;
        }
        .sf-reset #logs .traces li.warning {
            font-style: normal;
            background: #ffcc00;
        }
        /* fix for Opera not liking empty <li> */
        .sf-reset .traces li:after {
            content: \"\\00A0\";
        }
        .sf-reset .trace {
            border: 1px solid #D3D3D3;
            padding: 10px;
            overflow: auto;
            margin: 10px 0 20px;
        }
        .sf-reset .block-exception {
            -moz-border-radius: 16px;
            -webkit-border-radius: 16px;
            border-radius: 16px;
            margin-bottom: 20px;
            background-color: #f6f6f6;
            border: 1px solid #dfdfdf;
            padding: 30px 28px;
            word-wrap: break-word;
            overflow: hidden;
        }
        .sf-reset .block-exception div {
            color: #313131;
            font-size: 10px;
        }
        .sf-reset .block-exception-detected .illustration-exception,
        .sf-reset .block-exception-detected .text-exception {
            float: left;
        }
        .sf-reset .block-exception-detected .illustration-exception {
            width: 152px;
        }
        .sf-reset .block-exception-detected .text-exception {
            width: 670px;
            padding: 30px 44px 24px 46px;
            position: relative;
        }
        .sf-reset .text-exception .open-quote,
        .sf-reset .text-exception .close-quote {
            font-family: Arial, Helvetica, sans-serif;
            position: absolute;
            color: #C9C9C9;
            font-size: 8em;
        }
        .sf-reset .open-quote {
            top: 0;
            left: 0;
        }
        .sf-reset .close-quote {
            bottom: -0.5em;
            right: 50px;
        }
        .sf-reset .block-exception p {
            font-family: Arial, Helvetica, sans-serif;
        }
        .sf-reset .block-exception p a,
        .sf-reset .block-exception p a:hover {
            color: #565656;
        }
        .sf-reset .logs h2 {
            float: left;
            width: 654px;
        }
        .sf-reset .error-count, .sf-reset .support {
            float: right;
            width: 170px;
            text-align: right;
        }
        .sf-reset .error-count span {
             display: inline-block;
             background-color: #aacd4e;
             -moz-border-radius: 6px;
             -webkit-border-radius: 6px;
             border-radius: 6px;
             padding: 4px;
             color: white;
             margin-right: 2px;
             font-size: 11px;
             font-weight: bold;
        }

        .sf-reset .support a {
            display: inline-block;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            padding: 4px;
            color: #000000;
            margin-right: 2px;
            font-size: 11px;
            font-weight: bold;
        }

        .sf-reset .toggle {
            vertical-align: middle;
        }
        .sf-reset .linked ul,
        .sf-reset .linked li {
            display: inline;
        }
        .sf-reset #output-content {
            color: #000;
            font-size: 12px;
        }
        .sf-reset #traces-text pre {
            white-space: pre;
            font-size: 12px;
            font-family: monospace;
        }
    </style>
";
        
        $__internal_a9c88b30c63530c999e8b9a8b17bd9899b3371e15723d73607bbd58281edda9b->leave($__internal_a9c88b30c63530c999e8b9a8b17bd9899b3371e15723d73607bbd58281edda9b_prof);

        
        $__internal_4ef147cd91eae2d3230359beb774da0637c11c86f97bbe610465911c7784ee7f->leave($__internal_4ef147cd91eae2d3230359beb774da0637c11c86f97bbe610465911c7784ee7f_prof);

    }

    // line 136
    public function block_title($context, array $blocks = array())
    {
        $__internal_fad4abe4115eca9d1229fd3e3bb7e9ffff6c2ebf5e8ba855acc475cfff6fb8f4 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_fad4abe4115eca9d1229fd3e3bb7e9ffff6c2ebf5e8ba855acc475cfff6fb8f4->enter($__internal_fad4abe4115eca9d1229fd3e3bb7e9ffff6c2ebf5e8ba855acc475cfff6fb8f4_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        $__internal_9b0670e2afd7aca4e53d1ec8f26c63262dd39111e71852a55b657ade93c795f7 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_9b0670e2afd7aca4e53d1ec8f26c63262dd39111e71852a55b657ade93c795f7->enter($__internal_9b0670e2afd7aca4e53d1ec8f26c63262dd39111e71852a55b657ade93c795f7_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        // line 137
        echo "    ";
        echo twig_escape_filter($this->env, $this->getAttribute(($context["exception"] ?? $this->getContext($context, "exception")), "message", array()), "html", null, true);
        echo " (";
        echo twig_escape_filter($this->env, ($context["status_code"] ?? $this->getContext($context, "status_code")), "html", null, true);
        echo " ";
        echo twig_escape_filter($this->env, ($context["status_text"] ?? $this->getContext($context, "status_text")), "html", null, true);
        echo ")
";
        
        $__internal_9b0670e2afd7aca4e53d1ec8f26c63262dd39111e71852a55b657ade93c795f7->leave($__internal_9b0670e2afd7aca4e53d1ec8f26c63262dd39111e71852a55b657ade93c795f7_prof);

        
        $__internal_fad4abe4115eca9d1229fd3e3bb7e9ffff6c2ebf5e8ba855acc475cfff6fb8f4->leave($__internal_fad4abe4115eca9d1229fd3e3bb7e9ffff6c2ebf5e8ba855acc475cfff6fb8f4_prof);

    }

    // line 140
    public function block_body($context, array $blocks = array())
    {
        $__internal_c1f70f4fea259ee4a5c010af840d3eb397360ae154071ee7e3329d8e382ff43f = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_c1f70f4fea259ee4a5c010af840d3eb397360ae154071ee7e3329d8e382ff43f->enter($__internal_c1f70f4fea259ee4a5c010af840d3eb397360ae154071ee7e3329d8e382ff43f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        $__internal_f4e96abe6d573619ead94e6123f1d8b2064df5bd7ba7c5abd24bd184b3c9dd8e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_f4e96abe6d573619ead94e6123f1d8b2064df5bd7ba7c5abd24bd184b3c9dd8e->enter($__internal_f4e96abe6d573619ead94e6123f1d8b2064df5bd7ba7c5abd24bd184b3c9dd8e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 141
        echo "    ";
        $this->loadTemplate("@Twig/Exception/exception.html.twig", "@Twig/Exception/exception_full.html.twig", 141)->display($context);
        
        $__internal_f4e96abe6d573619ead94e6123f1d8b2064df5bd7ba7c5abd24bd184b3c9dd8e->leave($__internal_f4e96abe6d573619ead94e6123f1d8b2064df5bd7ba7c5abd24bd184b3c9dd8e_prof);

        
        $__internal_c1f70f4fea259ee4a5c010af840d3eb397360ae154071ee7e3329d8e382ff43f->leave($__internal_c1f70f4fea259ee4a5c010af840d3eb397360ae154071ee7e3329d8e382ff43f_prof);

    }

    public function getTemplateName()
    {
        return "@Twig/Exception/exception_full.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  226 => 141,  217 => 140,  200 => 137,  191 => 136,  51 => 4,  42 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends '@Twig/layout.html.twig' %}

{% block head %}
    <style>
        .sf-reset .traces {
            padding-bottom: 14px;
        }
        .sf-reset .traces li {
            font-size: 12px;
            color: #868686;
            padding: 5px 4px;
            list-style-type: decimal;
            margin-left: 20px;
        }
        .sf-reset #logs .traces li.error {
            font-style: normal;
            color: #AA3333;
            background: #f9ecec;
        }
        .sf-reset #logs .traces li.warning {
            font-style: normal;
            background: #ffcc00;
        }
        /* fix for Opera not liking empty <li> */
        .sf-reset .traces li:after {
            content: \"\\00A0\";
        }
        .sf-reset .trace {
            border: 1px solid #D3D3D3;
            padding: 10px;
            overflow: auto;
            margin: 10px 0 20px;
        }
        .sf-reset .block-exception {
            -moz-border-radius: 16px;
            -webkit-border-radius: 16px;
            border-radius: 16px;
            margin-bottom: 20px;
            background-color: #f6f6f6;
            border: 1px solid #dfdfdf;
            padding: 30px 28px;
            word-wrap: break-word;
            overflow: hidden;
        }
        .sf-reset .block-exception div {
            color: #313131;
            font-size: 10px;
        }
        .sf-reset .block-exception-detected .illustration-exception,
        .sf-reset .block-exception-detected .text-exception {
            float: left;
        }
        .sf-reset .block-exception-detected .illustration-exception {
            width: 152px;
        }
        .sf-reset .block-exception-detected .text-exception {
            width: 670px;
            padding: 30px 44px 24px 46px;
            position: relative;
        }
        .sf-reset .text-exception .open-quote,
        .sf-reset .text-exception .close-quote {
            font-family: Arial, Helvetica, sans-serif;
            position: absolute;
            color: #C9C9C9;
            font-size: 8em;
        }
        .sf-reset .open-quote {
            top: 0;
            left: 0;
        }
        .sf-reset .close-quote {
            bottom: -0.5em;
            right: 50px;
        }
        .sf-reset .block-exception p {
            font-family: Arial, Helvetica, sans-serif;
        }
        .sf-reset .block-exception p a,
        .sf-reset .block-exception p a:hover {
            color: #565656;
        }
        .sf-reset .logs h2 {
            float: left;
            width: 654px;
        }
        .sf-reset .error-count, .sf-reset .support {
            float: right;
            width: 170px;
            text-align: right;
        }
        .sf-reset .error-count span {
             display: inline-block;
             background-color: #aacd4e;
             -moz-border-radius: 6px;
             -webkit-border-radius: 6px;
             border-radius: 6px;
             padding: 4px;
             color: white;
             margin-right: 2px;
             font-size: 11px;
             font-weight: bold;
        }

        .sf-reset .support a {
            display: inline-block;
            -moz-border-radius: 6px;
            -webkit-border-radius: 6px;
            border-radius: 6px;
            padding: 4px;
            color: #000000;
            margin-right: 2px;
            font-size: 11px;
            font-weight: bold;
        }

        .sf-reset .toggle {
            vertical-align: middle;
        }
        .sf-reset .linked ul,
        .sf-reset .linked li {
            display: inline;
        }
        .sf-reset #output-content {
            color: #000;
            font-size: 12px;
        }
        .sf-reset #traces-text pre {
            white-space: pre;
            font-size: 12px;
            font-family: monospace;
        }
    </style>
{% endblock %}

{% block title %}
    {{ exception.message }} ({{ status_code }} {{ status_text }})
{% endblock %}

{% block body %}
    {% include '@Twig/Exception/exception.html.twig' %}
{% endblock %}
", "@Twig/Exception/exception_full.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\TwigBundle\\Resources\\views\\Exception\\exception_full.html.twig");
    }
}
