<?php

/* base.html.twig */
class __TwigTemplate_a17f9d7aa975e34f4e0cc44eeab7f33089147d69ffdc6090114c99e26dfbd157 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'stylesheets' => array($this, 'block_stylesheets'),
            'body_id' => array($this, 'block_body_id'),
            'body' => array($this, 'block_body'),
            'main' => array($this, 'block_main'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_33a49e5f55c71b581bf3f220ef37426d35f35d9ea0d58390232f62fee3e74a66 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_33a49e5f55c71b581bf3f220ef37426d35f35d9ea0d58390232f62fee3e74a66->enter($__internal_33a49e5f55c71b581bf3f220ef37426d35f35d9ea0d58390232f62fee3e74a66_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "base.html.twig"));

        $__internal_60e2e71aede506fd74278bee7f77a0c18c13dc6c4cf50ac9eeabf678c199b9c4 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_60e2e71aede506fd74278bee7f77a0c18c13dc6c4cf50ac9eeabf678c199b9c4->enter($__internal_60e2e71aede506fd74278bee7f77a0c18c13dc6c4cf50ac9eeabf678c199b9c4_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 6
        echo "<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <title>";
        // line 10
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
    ";
        // line 11
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 16
        echo "    <link rel=\"icon\" type=\"image/x-icon\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("favicon.ico"), "html", null, true);
        echo "\"/>
</head>

<body id=\"";
        // line 19
        $this->displayBlock('body_id', $context, $blocks);
        echo "\">
";
        // line 20
        $this->displayBlock('body', $context, $blocks);
        // line 23
        echo "</body>
</html>
";
        
        $__internal_33a49e5f55c71b581bf3f220ef37426d35f35d9ea0d58390232f62fee3e74a66->leave($__internal_33a49e5f55c71b581bf3f220ef37426d35f35d9ea0d58390232f62fee3e74a66_prof);

        
        $__internal_60e2e71aede506fd74278bee7f77a0c18c13dc6c4cf50ac9eeabf678c199b9c4->leave($__internal_60e2e71aede506fd74278bee7f77a0c18c13dc6c4cf50ac9eeabf678c199b9c4_prof);

    }

    // line 10
    public function block_title($context, array $blocks = array())
    {
        $__internal_1e09478acf3c5b27c39f0a335a5d1aa5dad5ac37ecdc58f34bc2049c7aed8b67 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_1e09478acf3c5b27c39f0a335a5d1aa5dad5ac37ecdc58f34bc2049c7aed8b67->enter($__internal_1e09478acf3c5b27c39f0a335a5d1aa5dad5ac37ecdc58f34bc2049c7aed8b67_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        $__internal_472eadabd2ecef228fc8f79b65e473c64b2c43fb10b7509aad99750e17463ab9 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_472eadabd2ecef228fc8f79b65e473c64b2c43fb10b7509aad99750e17463ab9->enter($__internal_472eadabd2ecef228fc8f79b65e473c64b2c43fb10b7509aad99750e17463ab9_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        echo "Project Rider";
        
        $__internal_472eadabd2ecef228fc8f79b65e473c64b2c43fb10b7509aad99750e17463ab9->leave($__internal_472eadabd2ecef228fc8f79b65e473c64b2c43fb10b7509aad99750e17463ab9_prof);

        
        $__internal_1e09478acf3c5b27c39f0a335a5d1aa5dad5ac37ecdc58f34bc2049c7aed8b67->leave($__internal_1e09478acf3c5b27c39f0a335a5d1aa5dad5ac37ecdc58f34bc2049c7aed8b67_prof);

    }

    // line 11
    public function block_stylesheets($context, array $blocks = array())
    {
        $__internal_cd933b0a8090adef47ed43d8ccc215a3cee3118fd25795d80329d303a3b6f0e4 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_cd933b0a8090adef47ed43d8ccc215a3cee3118fd25795d80329d303a3b6f0e4->enter($__internal_cd933b0a8090adef47ed43d8ccc215a3cee3118fd25795d80329d303a3b6f0e4_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "stylesheets"));

        $__internal_4653abbe1dca5d837574fa2ab25c0807bd676786e3355e5d69a4bb02c76923d3 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_4653abbe1dca5d837574fa2ab25c0807bd676786e3355e5d69a4bb02c76923d3->enter($__internal_4653abbe1dca5d837574fa2ab25c0807bd676786e3355e5d69a4bb02c76923d3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 12
        echo "        <link rel=\"stylesheet\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/reset.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/style.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/create-style.css"), "html", null, true);
        echo "\">
    ";
        
        $__internal_4653abbe1dca5d837574fa2ab25c0807bd676786e3355e5d69a4bb02c76923d3->leave($__internal_4653abbe1dca5d837574fa2ab25c0807bd676786e3355e5d69a4bb02c76923d3_prof);

        
        $__internal_cd933b0a8090adef47ed43d8ccc215a3cee3118fd25795d80329d303a3b6f0e4->leave($__internal_cd933b0a8090adef47ed43d8ccc215a3cee3118fd25795d80329d303a3b6f0e4_prof);

    }

    // line 19
    public function block_body_id($context, array $blocks = array())
    {
        $__internal_42a3a7ba45be3f0a6486bccb23c2995b3be74bfddcf9220491b47db4e5720f47 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_42a3a7ba45be3f0a6486bccb23c2995b3be74bfddcf9220491b47db4e5720f47->enter($__internal_42a3a7ba45be3f0a6486bccb23c2995b3be74bfddcf9220491b47db4e5720f47_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body_id"));

        $__internal_236bd7848b3721b152ab99056ec1cccf0eb324b75e75bc14dd8ac8615ccbfc4e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_236bd7848b3721b152ab99056ec1cccf0eb324b75e75bc14dd8ac8615ccbfc4e->enter($__internal_236bd7848b3721b152ab99056ec1cccf0eb324b75e75bc14dd8ac8615ccbfc4e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body_id"));

        
        $__internal_236bd7848b3721b152ab99056ec1cccf0eb324b75e75bc14dd8ac8615ccbfc4e->leave($__internal_236bd7848b3721b152ab99056ec1cccf0eb324b75e75bc14dd8ac8615ccbfc4e_prof);

        
        $__internal_42a3a7ba45be3f0a6486bccb23c2995b3be74bfddcf9220491b47db4e5720f47->leave($__internal_42a3a7ba45be3f0a6486bccb23c2995b3be74bfddcf9220491b47db4e5720f47_prof);

    }

    // line 20
    public function block_body($context, array $blocks = array())
    {
        $__internal_191933c9b7f69403500ae1ec36b8588768d0a440820861cd9228f48684f0956e = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_191933c9b7f69403500ae1ec36b8588768d0a440820861cd9228f48684f0956e->enter($__internal_191933c9b7f69403500ae1ec36b8588768d0a440820861cd9228f48684f0956e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        $__internal_a5032d6b628045c8becf1a2b22a335105ee485e73109a3a7417c42ef7f777aa9 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_a5032d6b628045c8becf1a2b22a335105ee485e73109a3a7417c42ef7f777aa9->enter($__internal_a5032d6b628045c8becf1a2b22a335105ee485e73109a3a7417c42ef7f777aa9_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 21
        echo "    ";
        $this->displayBlock('main', $context, $blocks);
        
        $__internal_a5032d6b628045c8becf1a2b22a335105ee485e73109a3a7417c42ef7f777aa9->leave($__internal_a5032d6b628045c8becf1a2b22a335105ee485e73109a3a7417c42ef7f777aa9_prof);

        
        $__internal_191933c9b7f69403500ae1ec36b8588768d0a440820861cd9228f48684f0956e->leave($__internal_191933c9b7f69403500ae1ec36b8588768d0a440820861cd9228f48684f0956e_prof);

    }

    public function block_main($context, array $blocks = array())
    {
        $__internal_3b6d9733d94facf324ba6e9c5cfbcc4c67c2067d7dfcf9cda6a8e35aadd6d78f = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_3b6d9733d94facf324ba6e9c5cfbcc4c67c2067d7dfcf9cda6a8e35aadd6d78f->enter($__internal_3b6d9733d94facf324ba6e9c5cfbcc4c67c2067d7dfcf9cda6a8e35aadd6d78f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        $__internal_14c1d92b76f5f74c442afb2522dbd335e1603efebd20bd0a0a3a0bff5d101f2e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_14c1d92b76f5f74c442afb2522dbd335e1603efebd20bd0a0a3a0bff5d101f2e->enter($__internal_14c1d92b76f5f74c442afb2522dbd335e1603efebd20bd0a0a3a0bff5d101f2e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        
        $__internal_14c1d92b76f5f74c442afb2522dbd335e1603efebd20bd0a0a3a0bff5d101f2e->leave($__internal_14c1d92b76f5f74c442afb2522dbd335e1603efebd20bd0a0a3a0bff5d101f2e_prof);

        
        $__internal_3b6d9733d94facf324ba6e9c5cfbcc4c67c2067d7dfcf9cda6a8e35aadd6d78f->leave($__internal_3b6d9733d94facf324ba6e9c5cfbcc4c67c2067d7dfcf9cda6a8e35aadd6d78f_prof);

    }

    public function getTemplateName()
    {
        return "base.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  141 => 21,  132 => 20,  115 => 19,  103 => 14,  99 => 13,  94 => 12,  85 => 11,  67 => 10,  55 => 23,  53 => 20,  49 => 19,  42 => 16,  40 => 11,  36 => 10,  30 => 6,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{#
   This is the base template used as the application layout which contains the
   common elements and decorates all the other templates.
   See http://symfony.com/doc/current/book/templating.html#template-inheritance-and-layouts
#}
<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <title>{% block title %}Project Rider{% endblock %}</title>
    {% block stylesheets %}
        <link rel=\"stylesheet\" href=\"{{ asset('css/reset.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('css/style.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('css/create-style.css') }}\">
    {% endblock %}
    <link rel=\"icon\" type=\"image/x-icon\" href=\"{{ asset('favicon.ico') }}\"/>
</head>

<body id=\"{% block body_id %}{% endblock %}\">
{% block body %}
    {% block main %}{% endblock %}
{% endblock %}
</body>
</html>
", "base.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\app\\Resources\\views\\base.html.twig");
    }
}
