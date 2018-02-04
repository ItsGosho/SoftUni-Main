<?php

/* @Twig/layout.html.twig */
class __TwigTemplate_ac4577b33a1508f28febae67b77f8b093663a6c91b13d448e6865acd42e10dd8 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'head' => array($this, 'block_head'),
            'body' => array($this, 'block_body'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_9e1907c5265be6902a3fc315004d2c57432b9f3b2ce9c3608f30ca8b9c2fcea1 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_9e1907c5265be6902a3fc315004d2c57432b9f3b2ce9c3608f30ca8b9c2fcea1->enter($__internal_9e1907c5265be6902a3fc315004d2c57432b9f3b2ce9c3608f30ca8b9c2fcea1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/layout.html.twig"));

        $__internal_1eddf32552b96623f6151242acca20f9c68bdbc4ffc050ee10c406d1b8137308 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_1eddf32552b96623f6151242acca20f9c68bdbc4ffc050ee10c406d1b8137308->enter($__internal_1eddf32552b96623f6151242acca20f9c68bdbc4ffc050ee10c406d1b8137308_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/layout.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
    <head>
        <meta charset=\"";
        // line 4
        echo twig_escape_filter($this->env, $this->env->getCharset(), "html", null, true);
        echo "\" />
        <meta name=\"robots\" content=\"noindex,nofollow\" />
        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />
        <title>";
        // line 7
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
        <link rel=\"icon\" type=\"image/png\" href=\"";
        // line 8
        echo twig_include($this->env, $context, "@Twig/images/favicon.png.base64");
        echo "\">
        <style>";
        // line 9
        echo twig_include($this->env, $context, "@Twig/exception.css.twig");
        echo "</style>
        ";
        // line 10
        $this->displayBlock('head', $context, $blocks);
        // line 11
        echo "    </head>
    <body>
        <header>
            <div class=\"container\">
                <h1 class=\"logo\">";
        // line 15
        echo twig_include($this->env, $context, "@Twig/images/symfony-logo.svg");
        echo " Symfony Exception</h1>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/doc\">
                        <span class=\"icon\">";
        // line 19
        echo twig_include($this->env, $context, "@Twig/images/icon-book.svg");
        echo "</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Docs
                    </a>
                </div>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/support\">
                        <span class=\"icon\">";
        // line 26
        echo twig_include($this->env, $context, "@Twig/images/icon-support.svg");
        echo "</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Support
                    </a>
                </div>
            </div>
        </header>

        ";
        // line 33
        $this->displayBlock('body', $context, $blocks);
        // line 34
        echo "        ";
        echo twig_include($this->env, $context, "@Twig/base_js.html.twig");
        echo "
    </body>
</html>
";
        
        $__internal_9e1907c5265be6902a3fc315004d2c57432b9f3b2ce9c3608f30ca8b9c2fcea1->leave($__internal_9e1907c5265be6902a3fc315004d2c57432b9f3b2ce9c3608f30ca8b9c2fcea1_prof);

        
        $__internal_1eddf32552b96623f6151242acca20f9c68bdbc4ffc050ee10c406d1b8137308->leave($__internal_1eddf32552b96623f6151242acca20f9c68bdbc4ffc050ee10c406d1b8137308_prof);

    }

    // line 7
    public function block_title($context, array $blocks = array())
    {
        $__internal_862c4369fdc1fdef3436830e459e5ad2a7a6dc25b707c35efe748427a6c1c15d = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_862c4369fdc1fdef3436830e459e5ad2a7a6dc25b707c35efe748427a6c1c15d->enter($__internal_862c4369fdc1fdef3436830e459e5ad2a7a6dc25b707c35efe748427a6c1c15d_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        $__internal_b989610db6fa3a8003b73a28f18d65453c69c558655b777ba245c22ee5cf2aa3 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_b989610db6fa3a8003b73a28f18d65453c69c558655b777ba245c22ee5cf2aa3->enter($__internal_b989610db6fa3a8003b73a28f18d65453c69c558655b777ba245c22ee5cf2aa3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        
        $__internal_b989610db6fa3a8003b73a28f18d65453c69c558655b777ba245c22ee5cf2aa3->leave($__internal_b989610db6fa3a8003b73a28f18d65453c69c558655b777ba245c22ee5cf2aa3_prof);

        
        $__internal_862c4369fdc1fdef3436830e459e5ad2a7a6dc25b707c35efe748427a6c1c15d->leave($__internal_862c4369fdc1fdef3436830e459e5ad2a7a6dc25b707c35efe748427a6c1c15d_prof);

    }

    // line 10
    public function block_head($context, array $blocks = array())
    {
        $__internal_16fcabc92b48b6bccd9258862e06b7af01f1de333a245f3c877ed6d83f25b6ae = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_16fcabc92b48b6bccd9258862e06b7af01f1de333a245f3c877ed6d83f25b6ae->enter($__internal_16fcabc92b48b6bccd9258862e06b7af01f1de333a245f3c877ed6d83f25b6ae_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        $__internal_4b6eb082256db44b358facab227fe71a89a7546f75370245db64c0e2a654ed29 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_4b6eb082256db44b358facab227fe71a89a7546f75370245db64c0e2a654ed29->enter($__internal_4b6eb082256db44b358facab227fe71a89a7546f75370245db64c0e2a654ed29_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        
        $__internal_4b6eb082256db44b358facab227fe71a89a7546f75370245db64c0e2a654ed29->leave($__internal_4b6eb082256db44b358facab227fe71a89a7546f75370245db64c0e2a654ed29_prof);

        
        $__internal_16fcabc92b48b6bccd9258862e06b7af01f1de333a245f3c877ed6d83f25b6ae->leave($__internal_16fcabc92b48b6bccd9258862e06b7af01f1de333a245f3c877ed6d83f25b6ae_prof);

    }

    // line 33
    public function block_body($context, array $blocks = array())
    {
        $__internal_18653d2bd5fff9cdc5be21277d660bd9e99167273fd8d998783c925e465f4cc2 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_18653d2bd5fff9cdc5be21277d660bd9e99167273fd8d998783c925e465f4cc2->enter($__internal_18653d2bd5fff9cdc5be21277d660bd9e99167273fd8d998783c925e465f4cc2_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        $__internal_f76cb99e568932fb1c0b3421cc2001c9cdf33bac1fab6f29e2d686c50869a550 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_f76cb99e568932fb1c0b3421cc2001c9cdf33bac1fab6f29e2d686c50869a550->enter($__internal_f76cb99e568932fb1c0b3421cc2001c9cdf33bac1fab6f29e2d686c50869a550_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        
        $__internal_f76cb99e568932fb1c0b3421cc2001c9cdf33bac1fab6f29e2d686c50869a550->leave($__internal_f76cb99e568932fb1c0b3421cc2001c9cdf33bac1fab6f29e2d686c50869a550_prof);

        
        $__internal_18653d2bd5fff9cdc5be21277d660bd9e99167273fd8d998783c925e465f4cc2->leave($__internal_18653d2bd5fff9cdc5be21277d660bd9e99167273fd8d998783c925e465f4cc2_prof);

    }

    public function getTemplateName()
    {
        return "@Twig/layout.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  137 => 33,  120 => 10,  103 => 7,  88 => 34,  86 => 33,  76 => 26,  66 => 19,  59 => 15,  53 => 11,  51 => 10,  47 => 9,  43 => 8,  39 => 7,  33 => 4,  28 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("<!DOCTYPE html>
<html>
    <head>
        <meta charset=\"{{ _charset }}\" />
        <meta name=\"robots\" content=\"noindex,nofollow\" />
        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\" />
        <title>{% block title %}{% endblock %}</title>
        <link rel=\"icon\" type=\"image/png\" href=\"{{ include('@Twig/images/favicon.png.base64') }}\">
        <style>{{ include('@Twig/exception.css.twig') }}</style>
        {% block head %}{% endblock %}
    </head>
    <body>
        <header>
            <div class=\"container\">
                <h1 class=\"logo\">{{ include('@Twig/images/symfony-logo.svg') }} Symfony Exception</h1>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/doc\">
                        <span class=\"icon\">{{ include('@Twig/images/icon-book.svg') }}</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Docs
                    </a>
                </div>

                <div class=\"help-link\">
                    <a href=\"https://symfony.com/support\">
                        <span class=\"icon\">{{ include('@Twig/images/icon-support.svg') }}</span>
                        <span class=\"hidden-xs-down\">Symfony</span> Support
                    </a>
                </div>
            </div>
        </header>

        {% block body %}{% endblock %}
        {{ include('@Twig/base_js.html.twig') }}
    </body>
</html>
", "@Twig/layout.html.twig", "C:\\Users\\Gosho\\Desktop\\PHP-Skeleton\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\TwigBundle\\Resources\\views\\layout.html.twig");
    }
}
