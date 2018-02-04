<?php

/* @WebProfiler/Collector/router.html.twig */
class __TwigTemplate_9cc36d5ec5add1c3b58a73800826077a427f692a9c4bcd893e7730774ba78d70 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/router.html.twig", 1);
        $this->blocks = array(
            'toolbar' => array($this, 'block_toolbar'),
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
        $__internal_e008d6acdc508d86be1c73f4b3113f42831f6b4d02224eaee53f7a11a0da387a = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_e008d6acdc508d86be1c73f4b3113f42831f6b4d02224eaee53f7a11a0da387a->enter($__internal_e008d6acdc508d86be1c73f4b3113f42831f6b4d02224eaee53f7a11a0da387a_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/router.html.twig"));

        $__internal_5d89f004b9548b1c59375ecb24a038148cd6e7fe3c699bbbc3dcaf23daf2d867 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_5d89f004b9548b1c59375ecb24a038148cd6e7fe3c699bbbc3dcaf23daf2d867->enter($__internal_5d89f004b9548b1c59375ecb24a038148cd6e7fe3c699bbbc3dcaf23daf2d867_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/router.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_e008d6acdc508d86be1c73f4b3113f42831f6b4d02224eaee53f7a11a0da387a->leave($__internal_e008d6acdc508d86be1c73f4b3113f42831f6b4d02224eaee53f7a11a0da387a_prof);

        
        $__internal_5d89f004b9548b1c59375ecb24a038148cd6e7fe3c699bbbc3dcaf23daf2d867->leave($__internal_5d89f004b9548b1c59375ecb24a038148cd6e7fe3c699bbbc3dcaf23daf2d867_prof);

    }

    // line 3
    public function block_toolbar($context, array $blocks = array())
    {
        $__internal_18df580961c1e40527dab561911c193cc40a5d29b62e27344842a810d2e64be6 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_18df580961c1e40527dab561911c193cc40a5d29b62e27344842a810d2e64be6->enter($__internal_18df580961c1e40527dab561911c193cc40a5d29b62e27344842a810d2e64be6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        $__internal_b0fc8763edf70362b605adf2550f7720d86666c87b1f204ff2fb25ef48b670fa = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_b0fc8763edf70362b605adf2550f7720d86666c87b1f204ff2fb25ef48b670fa->enter($__internal_b0fc8763edf70362b605adf2550f7720d86666c87b1f204ff2fb25ef48b670fa_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        
        $__internal_b0fc8763edf70362b605adf2550f7720d86666c87b1f204ff2fb25ef48b670fa->leave($__internal_b0fc8763edf70362b605adf2550f7720d86666c87b1f204ff2fb25ef48b670fa_prof);

        
        $__internal_18df580961c1e40527dab561911c193cc40a5d29b62e27344842a810d2e64be6->leave($__internal_18df580961c1e40527dab561911c193cc40a5d29b62e27344842a810d2e64be6_prof);

    }

    // line 5
    public function block_menu($context, array $blocks = array())
    {
        $__internal_ff2d70da3d2407f87182e117c1916557fe65ff6cdebdb6a5b963a708e8fee07a = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_ff2d70da3d2407f87182e117c1916557fe65ff6cdebdb6a5b963a708e8fee07a->enter($__internal_ff2d70da3d2407f87182e117c1916557fe65ff6cdebdb6a5b963a708e8fee07a_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        $__internal_cf26c60efcb0af5f9efc064d18df9eb6641dc046ddf8b4189fb7082594a024b6 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_cf26c60efcb0af5f9efc064d18df9eb6641dc046ddf8b4189fb7082594a024b6->enter($__internal_cf26c60efcb0af5f9efc064d18df9eb6641dc046ddf8b4189fb7082594a024b6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        // line 6
        echo "<span class=\"label\">
    <span class=\"icon\">";
        // line 7
        echo twig_include($this->env, $context, "@WebProfiler/Icon/router.svg");
        echo "</span>
    <strong>Routing</strong>
</span>
";
        
        $__internal_cf26c60efcb0af5f9efc064d18df9eb6641dc046ddf8b4189fb7082594a024b6->leave($__internal_cf26c60efcb0af5f9efc064d18df9eb6641dc046ddf8b4189fb7082594a024b6_prof);

        
        $__internal_ff2d70da3d2407f87182e117c1916557fe65ff6cdebdb6a5b963a708e8fee07a->leave($__internal_ff2d70da3d2407f87182e117c1916557fe65ff6cdebdb6a5b963a708e8fee07a_prof);

    }

    // line 12
    public function block_panel($context, array $blocks = array())
    {
        $__internal_a1a87c090cb1a65a721d427264762175450b061c2eb1042cce9fcd97bf6b5802 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_a1a87c090cb1a65a721d427264762175450b061c2eb1042cce9fcd97bf6b5802->enter($__internal_a1a87c090cb1a65a721d427264762175450b061c2eb1042cce9fcd97bf6b5802_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        $__internal_f1189205a7917b696822e68ff25ec9e3c2652651d8160dd7db2df2f553c5f23a = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_f1189205a7917b696822e68ff25ec9e3c2652651d8160dd7db2df2f553c5f23a->enter($__internal_f1189205a7917b696822e68ff25ec9e3c2652651d8160dd7db2df2f553c5f23a_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        // line 13
        echo "    ";
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_router", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
        echo "
";
        
        $__internal_f1189205a7917b696822e68ff25ec9e3c2652651d8160dd7db2df2f553c5f23a->leave($__internal_f1189205a7917b696822e68ff25ec9e3c2652651d8160dd7db2df2f553c5f23a_prof);

        
        $__internal_a1a87c090cb1a65a721d427264762175450b061c2eb1042cce9fcd97bf6b5802->leave($__internal_a1a87c090cb1a65a721d427264762175450b061c2eb1042cce9fcd97bf6b5802_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/router.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  94 => 13,  85 => 12,  71 => 7,  68 => 6,  59 => 5,  42 => 3,  11 => 1,);
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

{% block toolbar %}{% endblock %}

{% block menu %}
<span class=\"label\">
    <span class=\"icon\">{{ include('@WebProfiler/Icon/router.svg') }}</span>
    <strong>Routing</strong>
</span>
{% endblock %}

{% block panel %}
    {{ render(path('_profiler_router', { token: token })) }}
{% endblock %}
", "@WebProfiler/Collector/router.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\router.html.twig");
    }
}
