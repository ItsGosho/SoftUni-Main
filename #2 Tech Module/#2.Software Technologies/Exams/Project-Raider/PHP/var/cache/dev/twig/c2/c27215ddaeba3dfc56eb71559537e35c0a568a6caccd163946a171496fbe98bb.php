<?php

/* :project:delete.html.twig */
class __TwigTemplate_95ed6f90a2f87a4dd4fd8a8a654ba46835b00a51611e215160345bb927c11637 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("base.html.twig", ":project:delete.html.twig", 1);
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
        $__internal_75e3f260d0b2af7609331662bc5789350ab47962c3d948ff7b88710de4c75fcd = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_75e3f260d0b2af7609331662bc5789350ab47962c3d948ff7b88710de4c75fcd->enter($__internal_75e3f260d0b2af7609331662bc5789350ab47962c3d948ff7b88710de4c75fcd_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:delete.html.twig"));

        $__internal_869760997c3fb89b270c8315893b05a8e3d40209f1a5987ff689961f47ab8715 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_869760997c3fb89b270c8315893b05a8e3d40209f1a5987ff689961f47ab8715->enter($__internal_869760997c3fb89b270c8315893b05a8e3d40209f1a5987ff689961f47ab8715_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", ":project:delete.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_75e3f260d0b2af7609331662bc5789350ab47962c3d948ff7b88710de4c75fcd->leave($__internal_75e3f260d0b2af7609331662bc5789350ab47962c3d948ff7b88710de4c75fcd_prof);

        
        $__internal_869760997c3fb89b270c8315893b05a8e3d40209f1a5987ff689961f47ab8715->leave($__internal_869760997c3fb89b270c8315893b05a8e3d40209f1a5987ff689961f47ab8715_prof);

    }

    // line 3
    public function block_main($context, array $blocks = array())
    {
        $__internal_5ce0f3572bf5bbc55e06201a2a12372118a78e25b71d133e6d3a6ffbf65d2c85 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_5ce0f3572bf5bbc55e06201a2a12372118a78e25b71d133e6d3a6ffbf65d2c85->enter($__internal_5ce0f3572bf5bbc55e06201a2a12372118a78e25b71d133e6d3a6ffbf65d2c85_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_7885850c705aa2922f9708399218f9f03e4db5429d3654a4bd1f3044bd064b1c = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_7885850c705aa2922f9708399218f9f03e4db5429d3654a4bd1f3044bd064b1c->enter($__internal_7885850c705aa2922f9708399218f9f03e4db5429d3654a4bd1f3044bd064b1c_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

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
        echo "\" disabled=\"disabled\"/>
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"
                      disabled=\"disabled\">";
        // line 16
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "description", array()), "html", null, true);
        echo "</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"";
        // line 20
        echo twig_escape_filter($this->env, $this->getAttribute(($context["project"] ?? $this->getContext($context, "project")), "budget", array()), "html", null, true);
        echo "\"
                   disabled=\"disabled\"/>
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Delete Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        ";
        // line 28
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Form\TwigRenderer')->searchAndRenderBlock($this->getAttribute(($context["form"] ?? $this->getContext($context, "form")), "_token", array()), 'row');
        echo "
    </form>
</div>
";
        
        $__internal_7885850c705aa2922f9708399218f9f03e4db5429d3654a4bd1f3044bd064b1c->leave($__internal_7885850c705aa2922f9708399218f9f03e4db5429d3654a4bd1f3044bd064b1c_prof);

        
        $__internal_5ce0f3572bf5bbc55e06201a2a12372118a78e25b71d133e6d3a6ffbf65d2c85->leave($__internal_5ce0f3572bf5bbc55e06201a2a12372118a78e25b71d133e6d3a6ffbf65d2c85_prof);

    }

    public function getTemplateName()
    {
        return ":project:delete.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  84 => 28,  73 => 20,  66 => 16,  58 => 11,  49 => 4,  40 => 3,  11 => 1,);
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
            <input class=\"create-title-content\" name=\"project[title]\" value=\"{{ project.title }}\" disabled=\"disabled\"/>
        </div>
        <div class=\"create-description\">
            <div class=\"create-description-label\">Description</div>
            <textarea rows=\"3\" class=\"create-description-content\" name=\"project[description]\"
                      disabled=\"disabled\">{{ project.description }}</textarea>
        </div>
        <div class=\"create-budget\">
            <div class=\"create-budget-label\">Budget</div>
            <input type=\"number\" min=\"0\" class=\"create-budget-content\" name=\"project[budget]\" value=\"{{ project.budget }}\"
                   disabled=\"disabled\"/>
        </div>
        <div class=\"create-button-holder\">
            <button type=\"submit\" class=\"submit-button\">Delete Project</button>
            <a type=\"button\" href=\"/\" class=\"back-button\">Back</a>
        </div>

        {{ form_row(form._token) }}
    </form>
</div>
{% endblock %}", ":project:delete.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\app/Resources\\views/project/delete.html.twig");
    }
}
