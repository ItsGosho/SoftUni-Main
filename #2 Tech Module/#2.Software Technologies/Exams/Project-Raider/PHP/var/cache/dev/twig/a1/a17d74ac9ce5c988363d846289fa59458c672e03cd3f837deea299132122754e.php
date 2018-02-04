<?php

/* @WebProfiler/Collector/exception.html.twig */
class __TwigTemplate_0acfe6e0d74ca654a1a4affc281db3f3a85b89e0dc74c98b09bfaf6fb7b9bf4c extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/exception.html.twig", 1);
        $this->blocks = array(
            'head' => array($this, 'block_head'),
            'menu' => array($this, 'block_menu'),
            'panel' => array($this, 'block_panel'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_2af4e251b65b0dd3d910c451030c63de23b2f9a331c9f264ecb4ff717c226124 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_2af4e251b65b0dd3d910c451030c63de23b2f9a331c9f264ecb4ff717c226124->enter($__internal_2af4e251b65b0dd3d910c451030c63de23b2f9a331c9f264ecb4ff717c226124_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/exception.html.twig"));

        $__internal_92031e8a47283ce4cdcf209960696599a389ede8ca89687a624361c8052780a2 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_92031e8a47283ce4cdcf209960696599a389ede8ca89687a624361c8052780a2->enter($__internal_92031e8a47283ce4cdcf209960696599a389ede8ca89687a624361c8052780a2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/exception.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_2af4e251b65b0dd3d910c451030c63de23b2f9a331c9f264ecb4ff717c226124->leave($__internal_2af4e251b65b0dd3d910c451030c63de23b2f9a331c9f264ecb4ff717c226124_prof);

        
        $__internal_92031e8a47283ce4cdcf209960696599a389ede8ca89687a624361c8052780a2->leave($__internal_92031e8a47283ce4cdcf209960696599a389ede8ca89687a624361c8052780a2_prof);

    }

    // line 3
    public function block_head($context, array $blocks = array())
    {
        $__internal_726d712688a9f6f7fa858f5370fedaca8ae6015b7e900963b138e6cb83119728 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_726d712688a9f6f7fa858f5370fedaca8ae6015b7e900963b138e6cb83119728->enter($__internal_726d712688a9f6f7fa858f5370fedaca8ae6015b7e900963b138e6cb83119728_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        $__internal_d8a7e58d79e4aed3bbb9e596a87cd3c027fba7961e0e29e5b26bb57d90285aed = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_d8a7e58d79e4aed3bbb9e596a87cd3c027fba7961e0e29e5b26bb57d90285aed->enter($__internal_d8a7e58d79e4aed3bbb9e596a87cd3c027fba7961e0e29e5b26bb57d90285aed_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        // line 4
        echo "    ";
        if ($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 5
            echo "        <style>
            ";
            // line 6
            echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_exception_css", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
            echo "
        </style>
    ";
        }
        // line 9
        echo "    ";
        $this->displayParentBlock("head", $context, $blocks);
        echo "
";
        
        $__internal_d8a7e58d79e4aed3bbb9e596a87cd3c027fba7961e0e29e5b26bb57d90285aed->leave($__internal_d8a7e58d79e4aed3bbb9e596a87cd3c027fba7961e0e29e5b26bb57d90285aed_prof);

        
        $__internal_726d712688a9f6f7fa858f5370fedaca8ae6015b7e900963b138e6cb83119728->leave($__internal_726d712688a9f6f7fa858f5370fedaca8ae6015b7e900963b138e6cb83119728_prof);

    }

    // line 12
    public function block_menu($context, array $blocks = array())
    {
        $__internal_5f76c6f6ac176c651137a8eb0ef0dd636a16a946c1846a52f086b05809177f94 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_5f76c6f6ac176c651137a8eb0ef0dd636a16a946c1846a52f086b05809177f94->enter($__internal_5f76c6f6ac176c651137a8eb0ef0dd636a16a946c1846a52f086b05809177f94_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        $__internal_e52419a764f6aa92a37a48215cbd2b4803b88263abdd8db57b10787f79d515f8 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_e52419a764f6aa92a37a48215cbd2b4803b88263abdd8db57b10787f79d515f8->enter($__internal_e52419a764f6aa92a37a48215cbd2b4803b88263abdd8db57b10787f79d515f8_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        // line 13
        echo "    <span class=\"label ";
        echo (($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) ? ("label-status-error") : ("disabled"));
        echo "\">
        <span class=\"icon\">";
        // line 14
        echo twig_include($this->env, $context, "@WebProfiler/Icon/exception.svg");
        echo "</span>
        <strong>Exception</strong>
        ";
        // line 16
        if ($this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 17
            echo "            <span class=\"count\">
                <span>1</span>
            </span>
        ";
        }
        // line 21
        echo "    </span>
";
        
        $__internal_e52419a764f6aa92a37a48215cbd2b4803b88263abdd8db57b10787f79d515f8->leave($__internal_e52419a764f6aa92a37a48215cbd2b4803b88263abdd8db57b10787f79d515f8_prof);

        
        $__internal_5f76c6f6ac176c651137a8eb0ef0dd636a16a946c1846a52f086b05809177f94->leave($__internal_5f76c6f6ac176c651137a8eb0ef0dd636a16a946c1846a52f086b05809177f94_prof);

    }

    // line 24
    public function block_panel($context, array $blocks = array())
    {
        $__internal_6565bc39db84a89acfc0ad8c9e0773ba1d3f38c5dd3193ee5ea33ab93e7d8323 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_6565bc39db84a89acfc0ad8c9e0773ba1d3f38c5dd3193ee5ea33ab93e7d8323->enter($__internal_6565bc39db84a89acfc0ad8c9e0773ba1d3f38c5dd3193ee5ea33ab93e7d8323_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        $__internal_ea7235690674e07797e2775a3922d1aea19a52dd6da14e4351ea8d971def5bd2 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_ea7235690674e07797e2775a3922d1aea19a52dd6da14e4351ea8d971def5bd2->enter($__internal_ea7235690674e07797e2775a3922d1aea19a52dd6da14e4351ea8d971def5bd2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        // line 25
        echo "    <h2>Exceptions</h2>

    ";
        // line 27
        if ( !$this->getAttribute(($context["collector"] ?? $this->getContext($context, "collector")), "hasexception", array())) {
            // line 28
            echo "        <div class=\"empty\">
            <p>No exception was thrown and caught during the request.</p>
        </div>
    ";
        } else {
            // line 32
            echo "        <div class=\"sf-reset\">
            ";
            // line 33
            echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_exception", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
            echo "
        </div>
    ";
        }
        
        $__internal_ea7235690674e07797e2775a3922d1aea19a52dd6da14e4351ea8d971def5bd2->leave($__internal_ea7235690674e07797e2775a3922d1aea19a52dd6da14e4351ea8d971def5bd2_prof);

        
        $__internal_6565bc39db84a89acfc0ad8c9e0773ba1d3f38c5dd3193ee5ea33ab93e7d8323->leave($__internal_6565bc39db84a89acfc0ad8c9e0773ba1d3f38c5dd3193ee5ea33ab93e7d8323_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/exception.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  138 => 33,  135 => 32,  129 => 28,  127 => 27,  123 => 25,  114 => 24,  103 => 21,  97 => 17,  95 => 16,  90 => 14,  85 => 13,  76 => 12,  63 => 9,  57 => 6,  54 => 5,  51 => 4,  42 => 3,  11 => 1,);
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

{% block head %}
    {% if collector.hasexception %}
        <style>
            {{ render(path('_profiler_exception_css', { token: token })) }}
        </style>
    {% endif %}
    {{ parent() }}
{% endblock %}

{% block menu %}
    <span class=\"label {{ collector.hasexception ? 'label-status-error' : 'disabled' }}\">
        <span class=\"icon\">{{ include('@WebProfiler/Icon/exception.svg') }}</span>
        <strong>Exception</strong>
        {% if collector.hasexception %}
            <span class=\"count\">
                <span>1</span>
            </span>
        {% endif %}
    </span>
{% endblock %}

{% block panel %}
    <h2>Exceptions</h2>

    {% if not collector.hasexception %}
        <div class=\"empty\">
            <p>No exception was thrown and caught during the request.</p>
        </div>
    {% else %}
        <div class=\"sf-reset\">
            {{ render(path('_profiler_exception', { token: token })) }}
        </div>
    {% endif %}
{% endblock %}
", "@WebProfiler/Collector/exception.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\exception.html.twig");
    }
}
