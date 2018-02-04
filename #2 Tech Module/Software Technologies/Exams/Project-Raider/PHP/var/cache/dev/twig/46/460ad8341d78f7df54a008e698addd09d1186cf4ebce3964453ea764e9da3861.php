<?php

/* @WebProfiler/Collector/ajax.html.twig */
class __TwigTemplate_1ba2844ce327644c79ce021cb22291f7c7f4345900a886756bff7f8093a09dc7 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/ajax.html.twig", 1);
        $this->blocks = array(
            'toolbar' => array($this, 'block_toolbar'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_c6760776e11fbd977cec86c5d453bb0f3da743fefe16ca6096529043144a3986 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_c6760776e11fbd977cec86c5d453bb0f3da743fefe16ca6096529043144a3986->enter($__internal_c6760776e11fbd977cec86c5d453bb0f3da743fefe16ca6096529043144a3986_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/ajax.html.twig"));

        $__internal_cbaf558a69113bd53273a905fe7f3e4e243b45d5ce16c302d69efda52cf750a3 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_cbaf558a69113bd53273a905fe7f3e4e243b45d5ce16c302d69efda52cf750a3->enter($__internal_cbaf558a69113bd53273a905fe7f3e4e243b45d5ce16c302d69efda52cf750a3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/ajax.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_c6760776e11fbd977cec86c5d453bb0f3da743fefe16ca6096529043144a3986->leave($__internal_c6760776e11fbd977cec86c5d453bb0f3da743fefe16ca6096529043144a3986_prof);

        
        $__internal_cbaf558a69113bd53273a905fe7f3e4e243b45d5ce16c302d69efda52cf750a3->leave($__internal_cbaf558a69113bd53273a905fe7f3e4e243b45d5ce16c302d69efda52cf750a3_prof);

    }

    // line 3
    public function block_toolbar($context, array $blocks = array())
    {
        $__internal_bacc9509a8b1faed4e5002660187d68fd06f8c1f344a70da86fb1aa23f671264 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_bacc9509a8b1faed4e5002660187d68fd06f8c1f344a70da86fb1aa23f671264->enter($__internal_bacc9509a8b1faed4e5002660187d68fd06f8c1f344a70da86fb1aa23f671264_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        $__internal_b2e08e84f572c02093281561851f24d2b76cc67bb959202ba2f037456c0b671e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_b2e08e84f572c02093281561851f24d2b76cc67bb959202ba2f037456c0b671e->enter($__internal_b2e08e84f572c02093281561851f24d2b76cc67bb959202ba2f037456c0b671e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        // line 4
        echo "    ";
        ob_start();
        // line 5
        echo "        ";
        echo twig_include($this->env, $context, "@WebProfiler/Icon/ajax.svg");
        echo "
        <span class=\"sf-toolbar-value sf-toolbar-ajax-request-counter\">0</span>
    ";
        $context["icon"] = ('' === $tmp = ob_get_clean()) ? '' : new Twig_Markup($tmp, $this->env->getCharset());
        // line 8
        echo "
    ";
        // line 9
        $context["text"] = ('' === $tmp = "        <div class=\"sf-toolbar-info-piece\">
            <b class=\"sf-toolbar-ajax-info\"></b>
        </div>
        <div class=\"sf-toolbar-info-piece\">
            <table class=\"sf-toolbar-ajax-requests\">
                <thead>
                    <tr>
                        <th>Method</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>URL</th>
                        <th>Time</th>
                        <th>Profile</th>
                    </tr>
                </thead>
                <tbody class=\"sf-toolbar-ajax-request-list\"></tbody>
            </table>
        </div>
    ") ? '' : new Twig_Markup($tmp, $this->env->getCharset());
        // line 29
        echo "
    ";
        // line 30
        echo twig_include($this->env, $context, "@WebProfiler/Profiler/toolbar_item.html.twig", array("link" => false));
        echo "
";
        
        $__internal_b2e08e84f572c02093281561851f24d2b76cc67bb959202ba2f037456c0b671e->leave($__internal_b2e08e84f572c02093281561851f24d2b76cc67bb959202ba2f037456c0b671e_prof);

        
        $__internal_bacc9509a8b1faed4e5002660187d68fd06f8c1f344a70da86fb1aa23f671264->leave($__internal_bacc9509a8b1faed4e5002660187d68fd06f8c1f344a70da86fb1aa23f671264_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/ajax.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  85 => 30,  82 => 29,  62 => 9,  59 => 8,  52 => 5,  49 => 4,  40 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends '@WebProfiler/Profiler/layout.html.twig' %}

{% block toolbar %}
    {% set icon %}
        {{ include('@WebProfiler/Icon/ajax.svg') }}
        <span class=\"sf-toolbar-value sf-toolbar-ajax-request-counter\">0</span>
    {% endset %}

    {% set text %}
        <div class=\"sf-toolbar-info-piece\">
            <b class=\"sf-toolbar-ajax-info\"></b>
        </div>
        <div class=\"sf-toolbar-info-piece\">
            <table class=\"sf-toolbar-ajax-requests\">
                <thead>
                    <tr>
                        <th>Method</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>URL</th>
                        <th>Time</th>
                        <th>Profile</th>
                    </tr>
                </thead>
                <tbody class=\"sf-toolbar-ajax-request-list\"></tbody>
            </table>
        </div>
    {% endset %}

    {{ include('@WebProfiler/Profiler/toolbar_item.html.twig', { link: false }) }}
{% endblock %}
", "@WebProfiler/Collector/ajax.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\ajax.html.twig");
    }
}
