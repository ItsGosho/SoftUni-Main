<?php

/* :project:create.html.twig */
class __TwigTemplate_a26619a49ffd084be16fd01c1365c207ea143da1747cb7b24ebe98f98b4867ef extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", ":project:create.html.twig", 1);
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
        $__internal_8726a7c644a4e058fc57317bdbd22cf6c429195a99df1a2a5fd277335374d3bb = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_8726a7c644a4e058fc57317bdbd22cf6c429195a99df1a2a5fd277335374d3bb->enter($__internal_8726a7c644a4e058fc57317bdbd22cf6c429195a99df1a2a5fd277335374d3bb_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:create.html.twig"));

        $__internal_e7cbde4b69c70f76dd0474355fa09bdd8d22e041d8d3171844e937df0ee2699e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_e7cbde4b69c70f76dd0474355fa09bdd8d22e041d8d3171844e937df0ee2699e->enter($__internal_e7cbde4b69c70f76dd0474355fa09bdd8d22e041d8d3171844e937df0ee2699e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:create.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_8726a7c644a4e058fc57317bdbd22cf6c429195a99df1a2a5fd277335374d3bb->leave($__internal_8726a7c644a4e058fc57317bdbd22cf6c429195a99df1a2a5fd277335374d3bb_prof);

        
        $__internal_e7cbde4b69c70f76dd0474355fa09bdd8d22e041d8d3171844e937df0ee2699e->leave($__internal_e7cbde4b69c70f76dd0474355fa09bdd8d22e041d8d3171844e937df0ee2699e_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_89891dbb1c5498281b372fc9a7befaeb2aad45877e9968e9e2c8a86b2faccc93 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_89891dbb1c5498281b372fc9a7befaeb2aad45877e9968e9e2c8a86b2faccc93->enter($__internal_89891dbb1c5498281b372fc9a7befaeb2aad45877e9968e9e2c8a86b2faccc93_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_c6ce0a8d61f7cb7d572986302a53e251b8397c27f98dc05a31caf091afe20a45 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_c6ce0a8d61f7cb7d572986302a53e251b8397c27f98dc05a31caf091afe20a45->enter($__internal_c6ce0a8d61f7cb7d572986302a53e251b8397c27f98dc05a31caf091afe20a45_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        // line 4
        echo "<div class=\"wrapper\">
    <form class=\"project-create\" method=\"post\">
        <div class=\"create-header\">
            Create Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"></textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Create Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        ";
        // line 26
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Form\TwigRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "_token", array()), 'row');
        echo "
    </form>
</div>
";
        
        $__internal_c6ce0a8d61f7cb7d572986302a53e251b8397c27f98dc05a31caf091afe20a45->leave($__internal_c6ce0a8d61f7cb7d572986302a53e251b8397c27f98dc05a31caf091afe20a45_prof);

        
        $__internal_89891dbb1c5498281b372fc9a7befaeb2aad45877e9968e9e2c8a86b2faccc93->leave($__internal_89891dbb1c5498281b372fc9a7befaeb2aad45877e9968e9e2c8a86b2faccc93_prof);

    }

    public function getTemplateName()
    {
        return ":project:create.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  73 => 26,  49 => 4,  40 => 3,  11 => 1,);
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
            Create Project
        </div>
        <div class=\"create-title\">
            <div class=\"create-title-label\">Title</div>
            <input class=\"create-title-content\" name=\"project[title]\" />
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"></textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" />
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Create Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        {{ form_row(form._token) }}
    </form>
</div>
{% endblock %}", ":project:create.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\app/Resources\\views/project/create.html.twig");
    }
}
