<?php

/* :project:edit.html.twig */
class __TwigTemplate_f74a49e7b764e29c89064a66290f06a0a7a19d5732515dbc160bce789e9e2829 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", ":project:edit.html.twig", 1);
        $this->blocks = array(
            'main' => array($this, 'block_main'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_a2510cd493a382a3ae65c0a97a1fec78441f56622fa296dc6603cb0f2ba0f7e2 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_a2510cd493a382a3ae65c0a97a1fec78441f56622fa296dc6603cb0f2ba0f7e2->enter($__internal_a2510cd493a382a3ae65c0a97a1fec78441f56622fa296dc6603cb0f2ba0f7e2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:edit.html.twig"));

        $__internal_db64af5a773b29f50910347be5241a9f66b53c92a296a9a759d784818bc52ae1 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_db64af5a773b29f50910347be5241a9f66b53c92a296a9a759d784818bc52ae1->enter($__internal_db64af5a773b29f50910347be5241a9f66b53c92a296a9a759d784818bc52ae1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:edit.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_a2510cd493a382a3ae65c0a97a1fec78441f56622fa296dc6603cb0f2ba0f7e2->leave($__internal_a2510cd493a382a3ae65c0a97a1fec78441f56622fa296dc6603cb0f2ba0f7e2_prof);

        
        $__internal_db64af5a773b29f50910347be5241a9f66b53c92a296a9a759d784818bc52ae1->leave($__internal_db64af5a773b29f50910347be5241a9f66b53c92a296a9a759d784818bc52ae1_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_53556abd433513ee387aa8c90f7ea51d72bec678e6ece19204c76bc35dcd54b1 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_53556abd433513ee387aa8c90f7ea51d72bec678e6ece19204c76bc35dcd54b1->enter($__internal_53556abd433513ee387aa8c90f7ea51d72bec678e6ece19204c76bc35dcd54b1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_3bc5f1941cb9f64ab9b50d24f791956f85a862710b439ac3580e9cf774fac9e6 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_3bc5f1941cb9f64ab9b50d24f791956f85a862710b439ac3580e9cf774fac9e6->enter($__internal_3bc5f1941cb9f64ab9b50d24f791956f85a862710b439ac3580e9cf774fac9e6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        // line 4
        echo "<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Delete Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" value=\"";
        // line 11
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "title", array()), "html", null, true);
        echo "\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\">";
        // line 15
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "description", array()), "html", null, true);
        echo "</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "budget", array()), "html", null, true);
        echo "\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Edit Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        ";
        // line 26
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Form\TwigRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "_token", array()), 'row');
        echo "
    </form>
</div>
";
        
        $__internal_3bc5f1941cb9f64ab9b50d24f791956f85a862710b439ac3580e9cf774fac9e6->leave($__internal_3bc5f1941cb9f64ab9b50d24f791956f85a862710b439ac3580e9cf774fac9e6_prof);

        
        $__internal_53556abd433513ee387aa8c90f7ea51d72bec678e6ece19204c76bc35dcd54b1->leave($__internal_53556abd433513ee387aa8c90f7ea51d72bec678e6ece19204c76bc35dcd54b1_prof);

    }

    public function getTemplateName()
    {
        return ":project:edit.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  82 => 26,  72 => 19,  65 => 15,  58 => 11,  49 => 4,  40 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends \"base.html.twig\" %}

{% block main %}
<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Delete Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" value=\"{{ project.title }}\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\">{{ project.description }}</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"{{ project.budget }}\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Edit Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        {{ form_row(form._token) }}
    </form>
</div>
{% endblock %}

", ":project:edit.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\app/Resources\\views/project/edit.html.twig");
    }
}
